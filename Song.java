class Song {
  //The song class has two fields, one for the songName and the other for length in seconds.
  private String songName = "";
  private int songLength = 0;

  public int getSongLength()
  {
    return songLength;
  }

  public String getSongName()
  {
    return songName;
  }

  public Song(String name, int length)//The constructor returns just saves the info and checks if there is valid info.
  {
    if (length > 0)
    {
      songName = name;
      songLength = length;
      System.out.println("Succesfully added song.");
    }
    else
    System.out.println("Task failed: song is less than 1 seconds.");
  }

  public String toString(){
    String temp = "Song name: " + this.songName + " \nSong length: " + this.songLength + " (" + this.songLength/60 + ":" + this.songLength%60 + ")";
    return temp;
  }
}