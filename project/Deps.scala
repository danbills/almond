
import sbt._
import sbt.Def.setting
import sbt.Keys.scalaVersion

object Deps {

  object Versions {
    def ammonite = setting {
      val sv = scalaVersion.value
      if (sv.startsWith("2.11.")) "1.6.7"
      else "1.6.9-15-6720d42"
    }
    def caseApp = "2.0.0-M9"
  }

  def ammoniteRepl = setting(("com.lihaoyi" % "ammonite-repl" % Versions.ammonite.value).cross(CrossVersion.full))
  def ammoniteReplApi = setting {
    val sv = scalaVersion.value
    val module =
      if (sv.startsWith("2.11.")) "ammonite-repl"
      else "ammonite-repl-api"
    ("com.lihaoyi" % module % Versions.ammonite.value).cross(CrossVersion.full)
  }
  def ammoniteSpark = "sh.almond" %% "ammonite-spark" % "0.6.0"
  def argonautShapeless = "com.github.alexarchambault" %% "argonaut-shapeless_6.2" % "1.2.0-M11"
  def caseAppAnnotations = "com.github.alexarchambault" %% "case-app-annotations" % Versions.caseApp
  def caseApp = "com.github.alexarchambault" %% "case-app" % Versions.caseApp
  def coursier = "io.get-coursier" %% "coursier" % "2.0.0-RC3-2"
  def coursierApi = "io.get-coursier" % "interface" % "0.0.10"
  def directories = "io.github.soc" % "directories" % "11"
  def fs2 = "co.fs2" %% "fs2-core" % "1.1.0-M1"
  def jansi = "org.fusesource.jansi" % "jansi" % "1.18"
  def jeromq = "org.zeromq" % "jeromq" % "0.5.1"
  def jvmRepr = "com.github.jupyter" % "jvm-repr" % "0.4.0"
  def metabrowseServer = "org.scalameta" %% "metabrowse-server" % "0.2.2"
  def scalaReflect = setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)
  def scalaRx = "com.lihaoyi" %% "scalarx" % "0.4.0"
  def scalatags = setting {
    val sv = scalaVersion.value
    val ver =
      if (sv.startsWith("2.11.")) "0.6.8"
      else "0.7.0"
    "com.lihaoyi" %% "scalatags" % ver
  }
  def slf4jNop = "org.slf4j" % "slf4j-nop" % "1.7.27"

  def sparkSql = "org.apache.spark" %% "spark-sql" % "2.4.0"

  def utest = setting {
    val sv = scalaVersion.value
    val ver =
      if (sv.startsWith("2.11.")) "0.6.7"
      else "0.6.9"
    "com.lihaoyi" %% "utest" % ver
  }

}
