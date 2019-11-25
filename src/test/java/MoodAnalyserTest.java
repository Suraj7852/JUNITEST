
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
    public void givenMoodAnalyserClassWhenProperShouldReturnObject() {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"),moodAnalyser);
    }

    @Test
    public void givenNullMoodShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood(null);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_NULL,e.type);
        }
    }


    @Test
    public void givenObject_WhenCorrect_ReturnsInfoUsingReflection()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        ObjectReflector.dump(moodAnalyser,3);
    }
}
