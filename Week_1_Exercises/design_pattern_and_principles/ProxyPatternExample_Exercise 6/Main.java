public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // The first call will load the image from the server
        image1.display();
        
        // The second call will use the cached image
        image1.display();

        // The first call will load the second image from the server
        image2.display();
        
        // The second call will use the cached image
        image2.display();
    }
}
