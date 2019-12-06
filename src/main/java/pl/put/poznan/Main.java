package pl.put.poznan;

import org.drools.core.audit.WorkingMemoryFileLogger;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.io.FileNotFoundException;

public class Main {

    public static void main(final String[] args) throws FileNotFoundException {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kContainer.getKieBase();
        KieSession session = kieBase.newKieSession();
        session.addEventListener( new DebugRuleRuntimeEventListener());
        session.addEventListener( new DebugAgendaEventListener());
        final WorkingMemoryFileLogger logger = new WorkingMemoryFileLogger();
        logger.setFileName("typeface_log");
        session.fireAllRules();
        logger.writeToDisk();
        session.dispose();
    }
}