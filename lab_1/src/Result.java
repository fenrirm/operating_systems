import java.util.Optional;

public class Result {
    private Optional result;
    private String status;

    public void accept(Optional result, String status ){
        this.result = result;
        this.status = status;
    }

    public void show(){
        System.out.println("Result - "+result+"Status - "+status);

    }

}
