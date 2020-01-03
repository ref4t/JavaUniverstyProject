

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.sound.sampled.*;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;

public class Speech{
	
	private LiveSpeechRecognizer recognizer;
	
	private String speechRecognitionResult;
	private String word;
		
	public Speech() {
			
		Configuration configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setGrammarPath("resource:/grammars");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);
		
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
	             System.out.println(ex);
		}
		
		
		startSpeechRecognition();
	}
	public void startSpeechRecognition() {
	    recognizer.startRecognition(true);
		System.out.println("Say something");	
			try {	
			    	SpeechResult speechResult = recognizer.getResult();
						if (speechResult == null)
							System.out.println("null");
						else {
							speechRecognitionResult = speechResult.getHypothesis();
							System.out.println("You said: [" + speechRecognitionResult + "]\n");
							
							}
						} 
					
			 catch (Exception ex) {
					
				System.out.println(ex);
					
				}
			
	}
	public String getWord(){
		return speechRecognitionResult;
	}

	

}
