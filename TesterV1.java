public class TesterV1 {
    public static void main(String args[]){
        Music[] music = new Music[10];
        music[0] = new Music("Backstabber", 2009, "Kesha");
        music[1] = new Music("deja vu", 2020, "Olivia Rodrigo");
        music[2] = new Music("Especially You", 2022, "Wallows");
        music[3] = new Music("This Love", 2014, "Taylor Swift");
        music[4] = new Music("Strangers Forever", 2022, "Maude Latour");
        music[5] = new Music("OMG Plz Don't Come Around", 2021, "THE DRIVER ERA");
        music[6] = new Music("cardigan", 2020, "Taylor Swift");
        music[7] = new Music("How to Be a Heartbreaker", 2012, "Marina and The Diamonds");
        music[8] = new Music("Happier than Ever", 2021, "Billie Eilish");
        music[9] = new Music("Teenage Dream", 2010, "Katy Perry");

        // empty array
        Music[] dest = new Music[10];

        printMusic(music);

        insertionTitle(music);
        binarySearchTitle(music, "deja vu");

        insertionYear(music);
        binarySearchYear(music, 2021);

        insertionArtist(music);
        binarySearchArtist(music, "Taylor Swift");
        
        sortByTitle(music, dest);
        sortByYear(music, dest);
        sortByArtist(music, dest);
    }

    // static method that traverses through the array and prints each element
    public static void printMusic(Music[] music){
        System.out.printf("%s %24s %8s", "Title", "Year", "Artist");
        System.out.println("\n---------------------------------------------------------");
        for(Music m : music){
            System.out.println(m.toString());
        }
    }

    // searches array for an artist
    public static void binarySearchArtist(Music[] m, String toFind){
        System.out.println("\n<< Searching for songs by " + toFind + " >>\n");

        int high = m.length;
        int low = -1;
        int probe;

        while(high - low > 1){
            probe = ( high + low ) / 2;

            if(m[probe].getArtist().compareTo(toFind) > 0){
                high = probe;
            }
            else{
                low = probe;
                if(m[probe].getArtist().compareTo(toFind) == 0){
                    break;
                }
            }
        }
        
        if( (low >= 0) && (m[low].getArtist().compareTo(toFind) == 0 )){
            linearPrintArtist(m, low, toFind);
        }
        else{
            System.out.println("NOT found: " + toFind);
        }

    }

    // methods to assist w/ printing binary search
    public static void linearPrintArtist(Music[] r, int low, String toFind){
        int i;
        int start = low;
        int end = low;

        // find starting point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getArtist().compareTo(toFind) == 0)){
            start = i;
            i--;
        }

        // find ending point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getArtist().compareTo(toFind) == 0)){
            end = i;
            i++;
        }

        // now print out the matches
        for(i = start; i <= end; i++){
            System.out.println(r[i]);
        }
    }

    public static void insertionArtist(Music[] source){
        Music[] dest = new Music[ source.length ];

        for( int i = 0 ; i < source.length ; i++ ){
            Music next = source[i];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 ){
                if(next.getArtist().compareTo(dest[k-1].getArtist()) > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
            
            // debugging statements 
            /*System.out.println("\nPass # " + i);
            for(Music m : dest){  
                if(m != null) System.out.printf("%-10s \n", m.getArtist());
            }*/
        }
        
        for(int i = 0; i < dest.length; i++){
            source[i] = dest[i];
        }
    }

    // searches array for year 
    public static void binarySearchYear(Music[] m, int toFind){
        System.out.println("\n<< Searching for songs released in " + toFind + " >>\n");

        int high = m.length;
        int low = -1;
        int probe;

        while( high - low > 1 ){
            probe = ( high + low ) / 2;

            if(m[probe].getYear() - toFind > 0){
                high = probe;
            }
            else{
                low = probe;
                if( m[probe].getYear() - toFind == 0){
                    break;
                }
            }
        }
        
        if((low >= 0) && (m[low].getYear() - toFind == 0)){
            linearPrintYear(m, low, toFind);
        }
        else{
            System.out.println("NOT found: " + toFind);
        }
            

    }

    // methods to assist w/ printing binary search
    public static void linearPrintYear(Music[] r, int low, int toFind){
        int i;
        int start = low;
        int end = low;

        // find start point of matches
        i = low - 1;
        while((i >= 0) && (r[i].getYear() - toFind == 0)){
            start = i;
            i--;
        }

        // find end point of matches
        i = low + 1;
        while((i < r.length) && (r[i].getYear() - toFind == 0)){
            end = i;
            i++;
        }

        // print out matches
        for(i = start; i <= end; i++){
            System.out.println(r[i]);
        }
            
    }

    public static void insertionYear(Music[] source){
        Music[] dest = new Music[ source.length ];

        for(int i = 0 ; i < source.length ; i++){
            Music next = source[i];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 ){
                if(next.getYear() - dest[k-1].getYear() > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
            
            // debugging statements 
            /*System.out.println("\nPass # " + i);
            for(Music m : dest){  
                if( m != null) System.out.printf("%-10s \n", m.getArtist() );
            }*/
        }
        
        for(int i = 0; i < dest.length; i++){
            source[i] = dest[i];
        }
            
    }

    // searches array for a song title
    public static void binarySearchTitle(Music[] r, String toFind ){
        System.out.println("\n<< Searching for " + toFind + " >>\n");

        int high = r.length;
        int low = -1;
        int probe;

        while( high - low > 1 ){
            probe = ( high + low ) / 2;
            if( r[probe].getTitle().compareTo(toFind) > 0){
                high = probe;
            } 
            else{
                low = probe;
            }
        }
        
        if( (low >= 0) && (r[low].getTitle().compareTo(toFind) == 0 )){
            System.out.println("Found: " + r[low].toString());
        }
        else{
            System.out.println("Not found." );
        }
    }

    // method to assist w/ printing binary search
    public static void insertionTitle(Music[] source)
    {
        Music[] dest = new Music[ source.length ];

        for( int i = 0 ; i < source.length ; i++ ){
            Music next = source[i];
            int insertIndex = 0;
            int k = i;

            while( k > 0 && insertIndex == 0 ){
                if(next.getTitle().compareTo(dest[k-1].getTitle()) > 0){
                    insertIndex = k;
                }
                else{
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[insertIndex] = next;
            
            // debugging statements 
            /*System.out.println("\nPass # " + i);
            for(Music m : dest){  
                if(m != null) System.out.printf("%-10s \n", m.getArtist());
            }*/
        }
        
        for(int i = 0; i < dest.length; i++)
            source[i] = dest[i];
    }

    // insertion method to sort by artist
    public static void sortByArtist(Music[] source, Music[] dest){
        for(int i = 0 ; i < source.length ; i++){
            Music next = source[i];
            int insertIndex = 0;
            int k = i;

                while(k > 0 && insertIndex == 0){
                    if(next.getArtist().compareTo( dest[k-1].getArtist() ) > 0) insertIndex = k;
                    else dest[k] = dest[k - 1];
                    k--;
                }

                dest[insertIndex] = next;
            }

            System.out.println("\n<< Sorting by artist >>\n");
            printMusic(dest);
    }

    // insertion method to sort by year
    public static void sortByYear(Music[] source, Music[] dest){
        for(int i = 0 ; i < source.length ; i++){
            Music next = source[i];
            int insertIndex = 0;
            int k = i;

                while(k > 0 && insertIndex == 0){
                    if(next.getYear() - dest[k-1].getYear() > 0) insertIndex = k;
                    else dest[k] = dest[k - 1];
                    k--;
                }

                dest[insertIndex] = next;
            }

            System.out.println("\n<< Sorting by year >>\n");
            printMusic(dest);
    }

    // insertion method to sort by title
    public static void sortByTitle(Music[] source, Music[] dest){
        for(int i = 0 ; i < source.length ; i++){
            Music next = source[i];
            int insertIndex = 0;
            int k = i;

                while(k > 0 && insertIndex == 0){
                    if( next.getTitle().toLowerCase().compareTo( dest[k-1].getTitle().toLowerCase()) > 0 ) insertIndex = k;
                    else dest[ k ] = dest[ k - 1 ];
                    k--;
                }

                dest[insertIndex] = next;
            }
            System.out.println("\n<< Sorting by title >>\n");
            printMusic(dest);
    }

}
