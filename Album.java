//Have code that you are able to save any album (also singles) using an album class. The album class will store the name of the album, the name of the artist, genre, release date, length of the album and maybe something else. 

class Album {
  private int length = 0; //Stored by seconds
  private String nameOfAlbum, nameOfArtist, albumGenre;
  private Song[] playList = new Song[0];

  public String getAlbumName(){
    return this.nameOfAlbum;
  }

    public String getArtistName(){
    return this.nameOfArtist;
  }

    public String getGenre(){
    return this.albumGenre;
  }

  public int amountOfSongs(){
    return this.playList.length;
  }
 
  public int getLengthOfAlbum(){
    if (this.playList.length > 0){
      int totalLength = 0;
      for (Song p : playList){ //Gets every song length and gets the sum. That is the album length.
        totalLength += p.getSongLength();
      }
      return totalLength;
    }
    return -1;
  }

  public Album (String name, String artist, String genre){
    if (!(
        artist.equals("") 
        && genre.equals("")
        ))//Checks if the genre and artist info is valid
    {
      nameOfAlbum = name;
      nameOfArtist = artist;
      albumGenre = genre;
      length = getLengthOfAlbum();
    }
  }

  public void addSong(int position, Song extraSong){ 
    if (!(position < 0))
    {
      if (playList.length >= 1)
      {
        Song[] temp = new Song[playList.length+1]; //Creates a whole new array with one extra space, for the new song.
        for (int k = 0; k < playList.length; k++){
          temp[k] = playList[k]; //Then copies the content of the original album.
        }

        for (int h = temp.length-1; h > position; h--){ //Shifts the whole array to the left by one.
          temp[h] = temp[h-1]; 
        }
        temp[position] = extraSong;
        playList = temp;
      }
      
      else
      {//If the playList has no songs, we create a new playlist.
        Song[] temp = new Song[1]; 
        temp[0] = extraSong;
        playList = temp;
      }
    }
    else
    {
      System.out.println("Position invlad: attempt to use a larger or smaller position value.");
    }
  }
  
  public void removeSong(int position){
    Song[] temp = new Song[playList.length-1]; //Creates a playlist with one less song.
    for (int k = 0; k < position; k++){
      temp[k] = playList[k]; //copies everything from the left hand side of the position.
    }
    for (int h = position+1; h < playList.length; h++){
      temp[h-1] = playList[h]; //copies everything from the right hand side of the position.
    }

    playList = temp;
  }

  public String toString(){
    String minutesString =  "";
    String secondsString = "";

    if (this.getLengthOfAlbum()%3600/60 < 10){
      minutesString = "0" + this.getLengthOfAlbum()%3600/60;
    }
    else minutesString = this.getLengthOfAlbum()%3600/60 + "";

    if (this.getLengthOfAlbum()%3600%60 < 10){
      secondsString = "0" + this.getLengthOfAlbum()%3600%60;
    }
    else secondsString = this.getLengthOfAlbum()%60 + "";
    String temp = "Name of the Album: " + nameOfAlbum + ". \nName of the Artist: " + nameOfArtist + ". \nGenre: " + albumGenre + ". \nLength: " + this.getLengthOfAlbum()/3600 
    + ":" + minutesString
    + ":" +  secondsString + ".";
    return temp;
  }

  public String getSongInfo(int position){
    String temp = "Position: " + position + " " + playList[position].toString();
    return temp;
  }
}