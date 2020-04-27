import java.io.IOException;

public class MainApp {

	public void beta_senti(String text,int id) {

		//System.out.println(text);
		
		SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
		Sentiment_helper sh=new Sentiment_helper();
		double[] sentiment_out=sentimentAnalyzer.getSentimentResult_text(text,sh,id);


		System.out.println("Sentiment Type: " +sh.gettype(id) );
		System.out.println("Very positive: " + sentiment_out[1]+"%");
		System.out.println("Positive: " + sentiment_out[2]+"%");
		System.out.println("Neutral: " + sentiment_out[4]+"%");
		System.out.println("Negative: " + sentiment_out[0]+"%");
		System.out.println("Very negative: " + sentiment_out[3]+"%");

	}

}
