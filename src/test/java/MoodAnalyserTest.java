
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("this is sad message");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood("This is sad message");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturn() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("this is happy message");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood("This is happy message");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void giveNullPointException() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser(null);
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood(null);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Please enter proper message",e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserClassWhenProperShouldReturnObject() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
        try {
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}
