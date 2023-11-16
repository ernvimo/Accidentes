import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        obtenerAccidentes();
    }

    public static void insertarCoche() {
        String url = "jdbc:mariadb://localhost:3306/simulacro";
        String usuario = "root";
        String contra = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contra);

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO coche(color, marca) VALUES (?,?)";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1,"verde");
            pt.setString(2, "h");
            pt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarAccidente() {
        String url = "jdbc:mariadb://localhost:3306/simulacro";
        String usuario = "root";
        String contra = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contra);

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "INSERT INTO accidente(cod_coche1, cod_coche2, num_muertos) VALUES (?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setInt(1,1);
            pt.setInt(2, 2);
            pt.setInt(3, 4);
            pt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarAccidentes(int numMuertes) {
        String url = "jdbc:mariadb://localhost:3306/simulacro";
        String usuario = "root";
        String contra = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contra);

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "DELETE FROM accidente WHERE num_muertos = ?";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setInt(1,0);
            pt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cambiarColor() {
        String url = "jdbc:mariadb://localhost:3306/simulacro";
        String usuario = "root";
        String contra = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contra);

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String sql = "UPDATE coche set color=? where color='verde'";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1,"rojo");
            pt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Accidente> obtenerAccidentes() {
        List<Accidente> accidentes = new ArrayList<>();
        String url = "jdbc:mariadb://localhost:3306/simulacro";
        String usuario = "root";
        String contra = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contra);

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("SELECT * from accidente");
            while(rs.next()) {
                Accidente accidente = new Accidente();
                accidente.setId(rs.getInt(1));
                accidente.setCod_coche1(rs.getInt(2));
                accidente.setCod_coche2(rs.getInt(3));
                accidente.setNum_muertos(rs.getInt(4));
                accidentes.add(accidente);
                System.out.println(accidente);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accidentes;
    }
}
