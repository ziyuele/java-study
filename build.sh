mvn clean package -DskipTests

rm -rf output
mkdir -p output 

cp -rf target/java-study-*.jar output
cp -rf target/lib output
cp -rf bin output

