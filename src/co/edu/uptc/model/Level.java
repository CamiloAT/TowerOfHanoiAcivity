package co.edu.uptc.model;

public class Level {
    private String nameLevel;
    private int numberDisk;

    public Level(String nameLevel, int numberDisk) {
        this.nameLevel = nameLevel;
        this.numberDisk = numberDisk;
    }

    public String getNameLevel() {
        return nameLevel;
    }
    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }
    public int getNumberDisk() {
        return numberDisk;
    }

	public void setNumberDisk(int numberDisk) {
		this.numberDisk = numberDisk;
	}
  
}