package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import co.edu.uptc.model.Level;

public class Persistence {
	private BufferedReader br;
	private File f;
	private FileReader fr;
	private Vector<Level> levels;

	public Persistence() {
		levels = new Vector<Level>();
		f = new File("resources/Levels.txt");
		this.openFile();
	}

	public void openFile() {
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			this.fillArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fillArray() throws IOException {
		String[] objectLevel= br.readLine().split(";");
		for (int i = 0; i < objectLevel.length; i++) {
			String parts[] = objectLevel[i].split(":");
			levels.add(new Level(parts[0], Integer.parseInt(parts[1])));
		}
		br.close();
	}

	public Vector<Level> getLevels() {
		return levels;
	}
	public static void main(String[] args) {
		new Persistence();
	}
}
