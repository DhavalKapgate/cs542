package wordCount.dsForStrings;

public interface Subject {
	public void notifyObserver();
	public void removeObserver(Node node);
	public void registerObserver(Node node);
}
