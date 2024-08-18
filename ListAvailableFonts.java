import java.awt.GraphicsEnvironment;

public class ListAvailableFonts {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilies = ge.getAvailableFontFamilyNames();
        
        // Print all available font families
        for (String fontFamily : fontFamilies) {
            System.out.println(fontFamily);
        }
    }
}
