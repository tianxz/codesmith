package org.vinci.codesmith.core.plugin.scurd

import org.vinci.codesmith.core.collector.database.domain.OneKeyConf
import org.vinci.codesmith.core.collector.database.domain.DataBaseConf
import org.vinci.codesmith.core.collector.database.service.TableService
import org.vinci.codesmith.core.engine.TemplateEngine
import org.vinci.codesmith.core.template.info.AuthorInfo
import org.vinci.codesmith.core.template.info.DateInfo
import org.vinci.codesmith.core.template.info.GenerateParams
import org.vinci.codesmith.core.template.info.ImportList
import org.vinci.codesmith.core.template.info.PackageInfo
import org.vinci.codesmith.core.utils.WordUtil
import org.vinci.codesmith.core.utils.UserDataSourceUtil
import jodd.io.FileNameUtil
import jodd.io.FileUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by XizeTian on 2016/12/19.
 * 根据velocity模板生成文件
 */
@Service
class GenerateService {
    @Autowired
    TableService            tableService
    @Autowired
    DbMeta2TemplateInfoUtil dbMeta2TemplateInfoUtil
    @Autowired
    TemplateEngine          templateEngine
    @Autowired
    UserDataSourceUtil      udbUtil

    /**
     * 根据指定表生成Domain
     * @param dbName
     * @param tableName
     */
    String generateCode(String ftlName, String tableName, GenerateParams generateParams) {
        return generateCodeMap(ftlName, udbUtil.defaultDbName, tableName, generateParams).code
    }

    Map generateCodeMap(String ftlName, String dbName, String tableName, GenerateParams generateParams) {
        String vmName = ftlName
        def table = tableService.getTable(dbName, tableName)
        def tableMapping = httpSession.getAttribute('USER:TABLE:MAPPING')
        def classInfo = dbMeta2TemplateInfoUtil.mysqlTableMeta2ClassInfo(table, tableMapping)
        def authorInfo = new AuthorInfo()
        def dateInfo = new DateInfo()
        def imports = new ImportList(classInfo.fields)
        def packageInfo = new PackageInfo(fullName: generateParams.packageInfo)

        def param = [
                "generateParams": generateParams,
                "packageInfo"   : packageInfo,
                "classInfo"     : classInfo,
                "authorInfo"    : authorInfo,
                "dateInfo"      : dateInfo,
                "imports"       : imports,
                "WordUtil"      : WordUtil.class
        ]
        String result = templateEngine.process(param, vmName)

        return [param: param, code: result]
    }

    void oneKeyGenerate(OneKeyConf conf) {
        //创建文件夹 usr/src/com/icss/
        def packageDir = "src/" + conf.packageName.replace(".", "/")
        def file = new File(FileNameUtil.concat(conf.dirPath, packageDir))
        if (!file.exists()) {
            file.mkdirs()
        }

        String domainDirName = 'domain'
        String daoDirName = 'dao'
        String mateDirName = 'domain/meta'
        String mybatisHelpDirName = 'domain/curd'
        String mapperDirName = 'mapper'
        DataBaseConf dbConf = udbUtil.getDataBaseConf()

        writeCodeToFile('hump', file.getPath(), 'domain', domainDirName, '', dbConf.name, conf.tableName, gp(conf.packageName, "domain"), '.java')
        writeCodeToFile('hump', file.getPath(), 'domain-meta', mateDirName, 'Mate', dbConf.name, conf.tableName, gp(conf.packageName, "domain.meta"), '.java')
        writeCodeToFile('hump', file.getPath(), 'dao', daoDirName, 'Dao', dbConf.name, conf.tableName, gp(conf.packageName, "dao"), '.java')
        writeCodeToFile('hump', file.getPath(), 'domain-update', mybatisHelpDirName, 'UpdateMap', dbConf.name, conf.tableName, gp(conf.packageName, "domain.curd"), '.java')
        writeCodeToFile('hump', file.getPath(), 'domain-query', mybatisHelpDirName, 'QueryMap', dbConf.name, conf.tableName, gp(conf.packageName, "domain.curd"), '.java')
        writeCodeToFile('strike', file.getPath(), 'mapper', mapperDirName, '-mapper', dbConf.name, conf.tableName, gp(conf.packageName, "mapper"), '.xml')
    }

    private GenerateParams gp(String packageName, String domain) {
        GenerateParams gp = new GenerateParams()
        gp.packageInfo = packageName + "." + domain
        gp.daoPackageInfo = packageName + '.dao'
        gp.domainPackageInfo = packageName + '.domain'
        gp.limitPackageInfo = packageName + '.block'
        return gp
    }

    private void writeCodeToFile(String fileNameType, String baseDir, String ftlName, String domainDirName, String fileNameSuffix, String dbName, String tableName, GenerateParams gp, String fileExtension) {
        //生成代码
        Map map = this.generateCodeMap(ftlName, dbName, tableName, gp)
        String fileName
        switch (fileNameType) {
            case 'hump':
                fileName = map.param.classInfo.name
                break
            case 'strike':
                fileName = WordUtil.of(map.param.classInfo.sqlAliasName).UnderlineField2StrikeField().out()
                break
            default:
                break
        }

        //创建临时文件并写入
        File tmpFile = FileUtil.createTempFile()
        try {
            tmpFile.write(map.code)

            //构造代码保存的路径
            String domainPath = FileNameUtil.concat(baseDir, domainDirName)
            String domainFileName = fileName + fileNameSuffix + fileExtension
            String fullDomainFileName = FileNameUtil.concat(domainPath, domainFileName)

            //复制临时文件为代码文件
            FileUtil.copy(tmpFile, new File(fullDomainFileName))
        } finally {
            FileUtil.delete(tmpFile)
        }
    }
}