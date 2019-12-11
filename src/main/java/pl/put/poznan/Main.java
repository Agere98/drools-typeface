package pl.put.poznan;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.type.Position;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.FileNotFoundException;

public class Main {

    public static void main(final String[] args) throws FileNotFoundException {
         
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kContainer.getKieBase();
        KieSession session = kieBase.newKieSession();

        TypefaceGUI.startGUI(session);
      
        session.addEventListener( new DebugRuleRuntimeEventListener());
        session.addEventListener( new DebugAgendaEventListener());
        session.fireAllRules();
        session.dispose();
    }

    public static class Question {
        public String content;
        @Position(0)
        public String subject;
        public String[] possibleAnswers;

        public String getSubject() {
            return subject;
        }

        @Override
        public String toString() {
            return content;
        }
    }
    public static class Answer {
        @Position(0)
        public String subject;
        @Position(1)
        public String answer;

        public String getAnswer() {
            return answer;
        }

        public Answer(String subj, String ans) {
            subject = subj;
            answer = ans;
        }
    }
    public static class Init {}
}