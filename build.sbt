scalaVersion := "2.10.1"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-target:jvm-1.7","-language:postfixOps")

//scalacOptions += "-feature"



dartDev := true

dartNoJs := true

//dartEntryPoints += "sosimple.dart"
dartEntryPoints ++= Seq("sosimple.dart")

dartWebUIEntryPoints += "speakers.html"

dartWebUIEntryPoints += "admin/dbbrowser.html"

