
public class Book{

        String name;
        String author;
        int yearOfPublication;
        int numberOfPages;

        public void getBook(String name){

            this.name = name;

        }

        public String getName(){
            return this.name;
        }

        public String getAuthor(){
            return this.author;
        }

        public int getYearOfPublication(){
            return this.yearOfPublication;
        }

        public int getNumberOfPages(){
            return this.numberOfPages;
        }

        public void setName(String name){
            this.name = name;
        }



        public void setAuthor(String author){
            this.author = author;
        }

        public void setYear(int year){
            this.yearOfPublication = year;
        }



        public void setNumberOfPages(int pages){

            this.numberOfPages = pages;

        }

    }



}
