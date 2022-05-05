import java.util.Scanner;
class Main {
  private static String[] namesOfSongs = new String[0];
  private static String[] namesOfAlbums = new String[0];
  private static Song[] allSongs = new Song[100];
  private static Album[] allAlbums = new Album[100];
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("░██████╗██╗░░██╗██████╗░░█████╗░████████╗██╗███████╗██╗░░░██╗\n██╔════╝██║░░██║██╔══██╗██╔══██╗╚══██╔══╝██║██╔════╝╚██╗░██╔╝\n╚█████╗░███████║██████╔╝██║░░██║░░░██║░░░██║█████╗░░░╚████╔╝░\n░╚═══██╗██╔══██║██╔═══╝░██║░░██║░░░██║░░░██║██╔══╝░░░░╚██╔╝░░\n██████╔╝██║░░██║██║░░░░░╚█████╔╝░░░██║░░░██║██║░░░░░░░░██║░░░\n╚═════╝░╚═╝░░╚═╝╚═╝░░░░░░╚════╝░░░░╚═╝░░░╚═╝╚═╝░░░░░░░░╚═╝░░░\n\n");
    int choice = 0;
    while (choice != 9){//While not quit, do this.
      System.out.println("\nCreate a new song (1)");
      System.out.println("Create a new album (2)");
      System.out.println("Add a song to an album (3)");
      System.out.println("Remove a song from an album (4)");
      System.out.println("View all albums (5)");
      System.out.println("View all songs within an album (6)");
      System.out.println("Quit (9)");
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
        }
        addSongtoAll(new Song(tempName, tempLength)); //This just makes a new object and moves it to the allSongs array. 
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
            temp[0] = tempAlbumName + " by " + tempArtistName;
            namesOfAlbums = temp;
          }
          
          else
          {//If the namesOfAlbums has no albums, we create a new namesOfAlbums.
            String[] temp = new String[1]; 
            temp[0] = tempAlbumName + " by " + tempArtistName;
            namesOfAlbums = temp;
          }
        }
        addAlbumtoAll(new Album(tempAlbumName, tempArtistName, tempGenre)); //This just makes a new object and moves it to the allAlbums array. 
      }
    
      if (choice == 3){
        if(!(namesOfSongs.length == 0)){
          System.out.println("Choose a song:");//Giving the user all songs avaliable.
          for (int i = 0; i < namesOfSongs.length; i++){
            System.out.println(namesOfSongs[i]);
          }

        String searchSongTitle = scan.nextLine();
          System.out.println("Choose an album:");//Giving the user all albums avaliable.
          for (int i = 0; i < namesOfAlbums.length; i++){
            System.out.println(namesOfAlbums[i]);
          }

        String searchAlbumTitle = scan.nextLine();
        System.out.println("Choose song position:"); //choose where you want the song to be.
        int tempPos = Integer.parseInt(scan.nextLine());

        boolean successfulOrNot = false;
        for (int i = 0; i < allSongs.length; i++){
          if (successfulOrNot) break; //Checks if the addition was successful.
            if (allSongs[i].getSongName() == (null)) break; //If the song is null, break.
              if (allSongs[i].getSongName().equals(searchSongTitle)){
                for (int j = 0; j < allAlbums.length; j++){
                  if (allAlbums[j].getAlbumName().equals(searchAlbumTitle)){//If the title is the same do stuff.
                    allAlbums[j].addSong(tempPos, allSongs[i]);
                    successfulOrNot = true;
                    allAlbums[j].toString();
                    break;
                  }
                }   
              }
        }

      
      if (successfulOrNot){ //Sends a little messege that tells you if it works or not.
        System.out.println("Addition was successful");
      }
      else
      System.out.println("Addition was failed");
      }
      }

      if (choice == 4){
        System.out.println("Choose an album:");
          for (int i = 0; i < namesOfAlbums.length; i++){
            System.out.println(namesOfAlbums[i]);
          }
        String tempAlbumName = scan.nextLine();
        int positionOfAlbum = 0; //Just to have a shortcut for later, so you don't have to loop through again.
        boolean successfullyFinished = false;
        for (int i = 0; i < allAlbums.length; i++){
          if (successfullyFinished) break;
            if(tempAlbumName.equals(allAlbums[i].getAlbumName())){
              for (int j = 0; j < allAlbums[i].amountOfSongs(); j++){
                positionOfAlbum = i;
                System.out.println(allAlbums[i].getSongInfo(j));
              }
              successfullyFinished = true;
              break;
            }
        }

        System.out.println("Which position is the song you want to remove reside? (0 position is the first position)");
        int tempPosition = Integer.parseInt(scan.nextLine());
        allAlbums[positionOfAlbum].removeSong(tempPosition);
      }

      if (choice == 5){
        for (int i = 0; i < allAlbums.length; i++){
          if (allAlbums[i] != null){
              System.out.println(allAlbums[i].toString());//Prints all information on about albums.
          } 
        }
      }

      if (choice == 6){
        System.out.println("Choose an album:");
          for (int i = 0; i < namesOfAlbums.length; i++){
            System.out.println(namesOfAlbums[i]);
          }
        String tempAlbumName = scan.nextLine();
        int positionOfAlbum = 0; //Just to have a shortcut for later, so you don't have to loop through again.
        boolean successfullyFinished = false;
        for (int i = 0; i < allAlbums.length; i++){
          if (successfullyFinished) break;
            if(tempAlbumName.equals(allAlbums[i].getAlbumName())){
              for (int j = 0; j < allAlbums[i].amountOfSongs(); j++){
                positionOfAlbum = i;
                System.out.println(allAlbums[i].getSongInfo(j));
              }
              successfullyFinished = true;
              break;
            }
        }
      }
  }
  }
  public static void addSongtoAll (Song s){//Copies an inserted song into the allSong array.
    for(int i = 0; i < allSongs.length; i++){
      if(allSongs[i] == null){
        allSongs[i] = s;
        break;
      }
    }
  }
  public static void addAlbumtoAll (Album s){//Copies an inserted album into the allAlbum array.
    for(int i = 0; i < allAlbums.length; i++){
      if(allAlbums[i] == null){
        allAlbums[i] = s;
        break;
      }
    }
  }
}