javac -cp "lib/*" -d out $(find src -name "*.java")

java -cp "lib/*:out" crimerecordsystem.Main
