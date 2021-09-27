public class DecodeImage {
 
	private String image;
	 
	public void DecodedImage(String image) {
	 this.image = image;
	}
	 
	@Override
	public String toString() {
		return image + ": is decoded";
	}
}
 
