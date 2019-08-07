# testmaven
## 如何导出pom到github上
1、在gradle.properties加上：
aar.maventest={你本地编译要生成pom的地址}
2、新建一个module，包含要提供出去的代码
3、在2的module的build.gradle文件，
（1）最前面加上apply plugin: 'maven'
（2）新增uploadArchives用于在本地生成pom
uploadArchives {
    repositories.mavenDeployer {
        //maven存放路径
        def deployPath = file(getProperty('aar.maventest'))
        repository(url: "file://${deployPath.absolutePath}")
//          repository(url: "") {
//            authentication(userName: "", password: "")
//          }
        pom.project {
            groupId "com.p.exportlib"
            artifactId "maventest"
            version "1.0"
        }
    }
}
groupId可以是包名，artifaceId是pom名，version是版本号
5、建好要在本地生成pom的目录
6、运行./gradlew xxx_module:uploadArchives
7、上传到github上，在浏览器打开，找到某个文本文件，点raw或者"查看原始数据"可以在浏览器看到地址
8、取出基础地址。
9、使用
（1）在build.gradle文件里面加上，maven { url "基础地址"}
（2）implementation "groupId:artifactId:version"

