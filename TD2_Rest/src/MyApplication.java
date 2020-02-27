import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
@ApplicationPath("/API/")
public class MyApplication extends Application{
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(Test.class);
        h.add( HelloWorld.class );
        h.add(Calcul.class);
        return h;
    }
}