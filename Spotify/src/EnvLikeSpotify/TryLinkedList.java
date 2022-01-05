package EnvLikeSpotify;

import java.util.Scanner;

public class TryLinkedList {
    public static LL songs = new LL();
    public static LL personelList = new LL();
    //*****************************************
    public static String[] values;
    public static String song = "";

    public static void main(String[] args) {
        LL names = new LL();
        String mesaj;
        char ch = 'C';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our program please select operation:\n" +
                "C <Name> : Creates a person with the name given in the line\n" +
                "S <Name> <Song> : Sets the <Name> likes the <Song>\n" +
                "E <Name> <Song> : Erases the assignment\n" +
                "L <Name> : Lists the songs of the person <Name> likes\n" +
                "N : List all name of registered people\n" +
                "M : List all the songs that liked by anyone\n" +
                "R: Recommends the most popular 3 different songs\n" +
                "Q: logging out of the system");
        while (ch != 'Q') {
            song = "";
            mesaj = scanner.nextLine();
            values = mesaj.split(" ");
            ch = mesaj.charAt(0);
            for (int s = 2; s < values.length; s++)
                if (!(song.equals("")))
                    song += " " + values[s];
                else
                    song += values[s];

            switch (ch) {
                case 'C':
                    if (!names.contains(values[1])) {
                        names.addEnd(values[1]);
                    } else
                        System.out.println("That name is available. Please Enter a different name!");
                    break;

                case 'S':
                    if (names.contains(values[1]) && !(personelList.contains(values[1] + "#!#" + song))) {
                        songs.addEnd(song);
                        personelList.addEnd((values[1] + "#!#" + song));
                        //  System.out.println(values[1] + " " + song);
                    } else
                        System.out.println("Please register, before add the song");
                    break;

                case 'E':
                    if (names.contains(values[1]) && songs.contains(song)) {
                        songs.EreaseAvailableValue(song);
                        personelList.EreaseAvailableValue((values[1] + "#!#" + song));
                        System.out.println(values[1] + "  does not like the song anymore  ");
                    } else
                        System.out.println("you are not registered or such a song is not available in the system");
                    break;

                case 'L':
                    for (int ix = personelList.size() - 1; ix >= 0; ix--) {
                        String[] temp = personelList.get(ix).split("#!#");
                        //temp[0]=kullanici adi, temp[1]= sarki adi
                        if (temp[0].equals(values[1])) {
                            System.out.println(temp[1]);
                        }
                    }
                    break;

                case 'N':
                    names.printList();
                    break;
                case 'M':
                    LL tempSong = new LL();
                    for (int ix = songs.size() - 1; ix >= 0; ix--) {
                        if (!tempSong.contains(songs.get(ix))) {
                            tempSong.addEnd(songs.get(ix));
                        }
                    }
                    tempSong.printList();
                    break;
                case 'R':
                    LL cloneSongs = new LL();
                    for (int i = 0; i < songs.size(); i++)
                        cloneSongs.addEnd(songs.get(i));
                    int top = 0;
                    String temp = "";
                    while (top < 3 && cloneSongs.size() != 0) {
                        for (int i = 0; i < cloneSongs.size() - 1; i++) {
                            int t = 1;
                            t += i;
                            int nextIndexElementNumber = cloneSongs.count(cloneSongs.get(t));
                            int currentElementNumber = (cloneSongs.count(cloneSongs.get(i)));
                            if (nextIndexElementNumber >= currentElementNumber) {
                                temp = cloneSongs.get(t);
                            }
                        }
                        if (cloneSongs.size() < 2)
                            System.out.println((top + 1) + ". most popular song: " + cloneSongs.get(0));
                        else {
                            System.out.println((top + 1) + ". most popular song: " + temp);
                            cloneSongs.EreaseAllAvailableValue(temp);
                        }
                        top++;
                    }
                    break;

                case 'Q':
                    System.out.println("logging out of the system");
                    break;

                default:
                    System.out.println("Default ");
                    break;
            }
        }
    }
}