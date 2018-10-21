namespace java com.kangjian.thriftstudy

service HelloService{
 string hello(1: string name);
}

//thrift -gen java -o ../java test.thrfit

