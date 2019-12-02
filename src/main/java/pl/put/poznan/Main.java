package pl.put.poznan;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(final String[] args) throws FileNotFoundException {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kContainer.getKieBase();
        KieSession session = kieBase.newKieSession();

        Gson gson = new Gson();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        JsonReader reader = new JsonReader(new InputStreamReader(classloader.getResourceAsStream("/typeface_questions.json")));
        Question[] questions = gson.fromJson(reader, Question[].class);
         for (Question q : questions) {
               System.out.println(q);
         }

        session.fireAllRules();
        session.dispose();
    }

    public class Question {
        public String content;
        public String subject;
        public String[] possibleAnswers;
        public String type;
        public String answer;

        public Question(String cont, String subj) {
            content = cont;
            subject = subj;
            possibleAnswers = new String[]{"yes", "no"};
            type = "single";
            answer = "";
        }

        public Question(String cont, String subj, String[] posans) {
            content = cont;
            subject = subj;
            possibleAnswers = posans;
            type = "single";
            answer = "";
        }

        public Question(String cont, String subj, String[] posans, String tp) {
            content = cont;
            subject = subj;
            possibleAnswers = posans;
            type = tp;
            answer = "";
        }
    }

}