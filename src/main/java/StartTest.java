import com.kangjian.thrifts.ThriftClient;
import com.kangjian.thrifts.ThriftServer;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

public class StartTest {
    public static void main(String[] args)throws InterruptedException, TException{
        System.out.println("start server...");
        ThriftServer server  = new ThriftServer();
        //TTransportException from here
        System.out.println("new server ok");
        server.start();
        System.out.println("server Start sussessful");
        // InterruptedException from here
        Thread.sleep(30);

        ThriftClient client = new ThriftClient();
        // TException TTransportException from here
        client.start();

        server.close();
        client.close();

    }
}
