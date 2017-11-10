package Interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Conexion {

    static String URL = "jdbc:postgresql://localhost:5432/LABORATORIOCLINICO";
    static String DRIVER = "org.postgresql.Driver";
    static String USUARIO = "postgres";
    static String CLAVE = "1096anderson";

    public void abrirRepor(String nom) throws SQLException, JRException{
      Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
               
             String dir ="src\\reportes\\"+nom;
        try {
            JasperReport reporteJasper= JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null,con);
            JasperViewer.viewReport(mostrarReporte,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
            
        } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }  
    }
    
   public ResultSet busquedaExamen(String nom) {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT E.COD_EXA,T.NOM_TIP,E.TIP_EXA,E.COS_EXA"
                        + " FROM EXAMENES E ,TIPO_EXAMEN T WHERE T.COD_TIP=E.COD_TIP_EXA AND E.TIP_EXA LIKE '%" + nom+ "%'";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return res;

    }
    public ResultSet busquedLabo(String CI) {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT * FROM LABORATORISTAS WHERE CI_LAB='" + CI + "'";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return res;

    }

    public boolean insertarUsuario(String[] datos) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "INSERT INTO CLIENTES VALUES ('" + datos[0] + "','" + datos[1] + "','" + datos[2] + "','" + datos[3]
                        + "','" + datos[4] + "','" + datos[5] + "','" + datos[6] + "','" + datos[7] + "')";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        } catch (ClassNotFoundException e) {

        }
        return true;

    }

    public ResultSet busquedLabo() {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT * FROM LABORATORISTAS";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        return res;

    }

    public ResultSet datos_cli(String CI) {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT NOM_CLI,APE_CLI,age(fech_nac_cli) as edad,"
                        + "TELF_CLI,CEL_CLI,E_MAIL,DIR_CLI FROM CLIENTES WHERE CED_CLI='" + CI + "'";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            // System.out.println(e.getMessage());
        }
        return res;

    }

    public boolean editarUsuario(String[] datos) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "UPDATE CLIENTES SET NOM_CLI='" + datos[1] + "',APE_CLI='" + datos[2] + "',FECH_NAC_CLI='" + datos[3]
                        + "',TELF_CLI='" + datos[4] + "',CEL_CLI='" + datos[5] + "',E_MAIL='" + datos[6] + "',DIR_CLI='" + datos[7] + "'"
                        + "WHERE CED_CLI='" + datos[0] + "';";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();
                return true;

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
        }
        

    }

    public ResultSet cliente(String CI) {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT * "
                        + "FROM CLIENTES WHERE CED_CLI='" + CI + "'";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            // System.out.println(e.getMessage());
        }
        return res;

    }

    public Object[][] datosExamenes() {

        Connection con;
        ResultSet res = null;
        int fil = contExamenes();
       // JOptionPane.showMessageDialog(null, String.valueOf(fil));
        Object[][] data = new Object[fil][4];
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT E.COD_EXA,T.NOM_TIP,E.TIP_EXA,E.COS_EXA"
                        + " FROM EXAMENES E ,TIPO_EXAMEN T WHERE T.COD_TIP=E.COD_TIP_EXA";
               PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                int i = 0;
                while (res.next() && i<fil) {
                    
                    data[i][0] = res.getString(1);
                    data[i][1] = res.getString(2);
                    data[i][2] = res.getString(3);
                    data[i][3] = res.getString(4);
                    i++;
                }

            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            
        }
        return data;

    }

    public int contExamenes() {

        Connection con;
        ResultSet res = null;
        int i = 0;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT count(COD_EXA)"
                        + "FROM EXAMENES ";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getInt(1);
                }

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        return i;

    }
    public int contConsltas() {

        Connection con;
        ResultSet res = null;
        int i = 0;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT count(COD_CON) "
                        + "FROM CONSULTAS ";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getInt(1);
                }

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
        }
        return i;

    }
    
    public boolean insertarConsulta(String[] datos,String[] exam) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "INSERT INTO CONSULTAS VALUES ('" + datos[0] + "','" + datos[1] + "','"
                        + datos[2] + "'," + "current_timestamp" + ",null)";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();
                
                int a = exam.length;
                for (int i = 0; i < a; i++) {
                    String[] d = new String[2];
                    d[0]=datos[0];
                    d[1]=exam[i];
                   insertarDetalleConsulta(d); 
                }

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        } catch (ClassNotFoundException e) {

        }
        return true;

    }
    public boolean insertarDetalleConsulta(String[] datos) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "INSERT INTO DETALLES VALUES ('" + datos[0] + "','" + datos[1] + "',null,null)";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();
                

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        } catch (ClassNotFoundException e) {

        }
        return true;

    }
    
    public ResultSet BusConsultasCli(String CICliente) {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT C.NOM_CLI,C.APE_CLI,CO.COD_CON,CO.CI_LAB,CO.FEC_CON "+
                              "FROM CLIENTES C,CONSULTAS CO "+
                              "WHERE C.CED_CLI=CO.CI_CLI "+
                              "AND CO.CI_CLI='"+CICliente+"'";
                        
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            // System.out.println(e.getMessage());
        }
        return res;

    }
    public ResultSet BusExamenesNull(String CICliente,String CILab) {

        Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT C.NOM_CLI,C.APE_CLI,CO.COD_CON,TE.NOM_TIP,E.TIP_EXA,D.RES_EXA,E.COD_EXA "+ 
                             "FROM CLIENTES C, CONSULTAS CO,DETALLES D,EXAMENES E,TIPO_EXAMEN TE "+
                             "WHERE CO.CI_CLI=C.CED_CLI "+
                             "AND CO.CI_CLI='"+CICliente+"' "+
                             "AND CO.CI_LAB='"+CILab+"' "+
                             "AND CO.COD_CON=D.COD_CON "+
                             "AND D.COD_EXA=E.COD_EXA "+
                             "AND E.COD_TIP_EXA=TE.COD_TIP "+
                             "AND D.RES_EXA IS NULL ";
                        
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

            } catch (Exception e) {
            }
        } catch (ClassNotFoundException e) {
            // System.out.println(e.getMessage());
        }
        return res;

    }
    
    public int contExamenesTOT(String codCon) {

        Connection con;
        ResultSet res = null;
        int i = 0;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT COUNT(COD_EXA) "+
                             "FROM DETALLES "+
                             "WHERE COD_CON='"+codCon+"' "+
                              "GROUP BY COD_CON";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getInt(1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;

    }
    
     public int contExamenesTER(String codCon) {

        Connection con;
        ResultSet res = null;
        int i = 0;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT COUNT(COD_EXA) "+
                             "FROM DETALLES "+
                             "WHERE COD_CON='"+codCon+"' "+
                             "AND RES_EXA IS NOT NULL "+
                              "GROUP BY COD_CON";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getInt(1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;

    }
    
     public double totalCOn(String codCon) {

        Connection con;
        ResultSet res = null;
        double i = 0;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT SUM(E.COS_EXA) "+
                             "FROM DETALLES D,EXAMENES E "+
                             "WHERE COD_CON='"+codCon+"' "+
                             "AND D.COD_EXA=E.COD_EXA "+
                             "GROUP BY COD_CON ";
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getDouble(1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;

    }
    
     
     public void abrirReporPar(String nom,String Cod) throws SQLException, JRException{
      Connection con;
        ResultSet res = null;
        try {
            Class.forName(DRIVER);
            
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
               
             String dir ="src\\reportes\\"+nom;
        try {
            Map parametros = new HashMap();
            parametros.put("CON",Cod);
            JasperReport reporteJasper= JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, parametros,con);
            JasperViewer.viewReport(mostrarReporte,false);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
            
        } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }  
    }
    
     public boolean insetarResultado(String cod,String res,String exa) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "UPDATE DETALLES SET RES_EXA='" + res + "',FEC_RES=NOW() "+
                         "WHERE COD_CON='" + cod + "'"
                        + "AND COD_EXA='"+exa+"';";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();
                return true;

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           return false;
        }
        

    }
    
     public int contExamenesTOT() {

        Connection con;
        ResultSet res = null;
        int i = 0;
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT COUNT(COD_EXA) "+
                             "FROM EXAMENES ";
                             
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getInt(1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;

    }
     public String codigoTipoExa(String nomTip) {

        Connection con;
        ResultSet res = null;
        String i = "-1";
        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "SELECT COD_TIP "+
                             "FROM TIPO_EXAMEN"
                        + "WHERE NOM_TIP='"+nomTip+"' ";
                             
                PreparedStatement pstm = con.prepareStatement(sql);
                res = pstm.executeQuery();

                while (res.next()) {
                    i = res.getString(1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return i;

    }
     
      public boolean insertarExamen(String[] datos) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "INSERT INTO EXAMENES VALUES ('" + datos[0] + "','" + datos[1] +"','"+datos[2] +"','"+datos[3] +"') "; 
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();
                
                return true;
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
               return false;
            }
        } catch (ClassNotFoundException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
          return false;
        }
        

    }

      
      public boolean insertarLab(String[] datos) {
        Connection con;

        try {
            Class.forName(DRIVER);
            try {
                con = DriverManager.getConnection(URL, USUARIO, CLAVE);
                String sql = "INSERT INTO LABORATORISTAS VALUES ('" + datos[0] + "','" + datos[1] + "','" + datos[2] + "','" + datos[3]
                        + "','" + datos[4] + "')";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.execute();
return true;
            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
                    return false;
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        

    }
}
