/**import java.util.Scanner;
class Main {
    public static void main(String[] args) {
    Album mintJams = new Album("Mint Jams", "Casiopea", "Jazz");
    System.out.println(mintJams.toString());

    Song takeMe = new Song("Take Me", 291);
    mintJams.addSong(0, takeMe);
    System.out.println(mintJams.toString());

    Song asayake = new Song("Asayake", 299);
    mintJams.addSong(0, asayake);
    System.out.println(mintJams.toString());
    System.out.println(mintJams.getSongInfo(0));

   Song midnightRendezvous = new Song("Midnight Rendezvous", 298);
   mintJams.addSong(2, midnightRendezvous);
   System.out.println(mintJams.toString());

    mintJams.removeSong(0);
    mintJams.addSong(0, takeMe);
    mintJams.removeSong(1);
    mintJams.addSong(1, asayake);
    System.out.println(mintJams.toString());
    System.out.println(mintJams.getSongInfo(0));
    System.out.println(mintJams.getSongInfo(1));
    System.out.println(mintJams.getSongInfo(2));
   
    Album viciousDelicious = new Album("Vicious Delicious", "Infected Mushroom", "Psytrance");
    Song becomingInsane = new Song("Becoming Insane", 440);
    viciousDelicious.addSong(0, becomingInsane);
    System.out.println(viciousDelicious.toString());
  }
  /**
  private static String[] namesOfSongs = new String[0];
  private static String[] namesOfAlbums = new String[0];
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("░██████╗██╗░░██╗██████╗░░█████╗░████████╗██╗███████╗██╗░░░██╗\n██╔════╝██║░░██║██╔══██╗██╔══██╗╚══██╔══╝██║██╔════╝╚██╗░██╔╝\n╚█████╗░███████║██████╔╝██║░░██║░░░██║░░░██║█████╗░░░╚████╔╝░\n░╚═══██╗██╔══██║██╔═══╝░██║░░██║░░░██║░░░██║██╔══╝░░░░╚██╔╝░░\n██████╔╝██║░░██║██║░░░░░╚█████╔╝░░░██║░░░██║██║░░░░░░░░██║░░░\n╚═════╝░╚═╝░░╚═╝╚═╝░░░░░░╚════╝░░░░╚═╝░░░╚═╝╚═╝░░░░░░░░╚═╝░░░\n\n");
    int choice = 0;
    while (choice != 7){//While not quit, do this.
      System.out.println("Create a new song (1)");
      System.out.println("Create a new album (2)");
      System.out.println("Add a song to an album (3)");
      System.out.println("Remove a song from an album (4)");
      System.out.println("View all albums (5)");
      System.out.println("General info about an album (6)");
      System.out.println("Quit (7)");
      choice = Integer.parseInt(scan.nextLine());

      if (choice == 1){
        System.out.println("Name of Song:");
        String tempName = scan.nextLine();
        System.out.println("Length in seconds");
        int tempLength = Integer.parseInt(scan.nextLine());
        
        if (!(tempName.equals("") && tempLength <= 0)){//Literally just saves the name of a song so you can search it up later.
          if (namesOfSongs.length >= 1)
          {
            String[] temp = new String[namesOfSongs.length+1]; //Creates a whole new array with one extra space, for the new song.
            for (int k = 0; k < namesOfSongs.length; k++){
              temp[k] = namesOfSongs[k]; //Then copies the content of the original album.
            }

            for (int h = temp.length-1; h > 0; h--){ //Shifts the whole array to the left by one.
              temp[h] = temp[h-1]; 
            }
            temp[0] = tempName;
            namesOfSongs = temp;
          }
          
          else
          {//If the namesOfSongs has no songs, we create a new namesOfSongs.
            String[] temp = new String[1]; 
            temp[0] = tempName;
            namesOfSongs = temp;
          }
          Song (namesOfSongs.toString()) = new Song(tempName, tempLength);
        }
      }
    
      if (choice == 2){
        System.out.println("Name of Album:");
        String tempAlbumName = scan.nextLine();
        System.out.println("Name of Artist:");
        String tempArtistName = scan.nextLine();
        System.out.println("Genre:");
        String tempGenre = scan.nextLine();
        
        if (!(tempArtistName.equals("") && tempGenre.equals(""))){
          if (namesOfAlbums.length >= 1)
          {
            String[] temp = new String[namesOfAlbums.length+1]; //Creates a whole new array with one extra space, for the new song.
            for (int k = 0; k < namesOfAlbums.length; k++){
              temp[k] = namesOfAlbums[k]; //Then copies the content of the original album.
            }

            for (int h = temp.length-1; h > 0; h--){ //Shifts the whole array to the left by one.
              temp[h] = temp[h-1]; 
            }
            temp[0] = tempAlbumName + "by " + tempArtistName;
            namesOfAlbums = temp;
          }
          
          else
          {//If the namesOfAlbums has no albums, we create a new namesOfAlbums.
            String[] temp = new String[1]; 
            temp[0] = tempAlbumName + "by " + tempArtistName;
            namesOfAlbums = temp;
          }
        }
      }
    

    
    }
  }
  public static String toStringForLength(int something){
    return something + "";
  }
}
*/