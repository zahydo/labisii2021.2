package co.unicauca.Restaurante.client.presentation;

import static co.unicauca.Restaurante.client.infra.Messages.successMessage;

import co.unicauca.Restaurante.commons.domain.Food;
import co.unicauca.Restaurante.commons.domain.FoodTypeEnum;
import co.unicauca.Restaurante.client.access.Factory;
import co.unicauca.Restaurante.client.access.IFoodAccess;
import co.unicauca.Restaurante.client.domain.services.FoodService;

/**
 * Interfaz gráfica de Consultar clientes
 *
 * @author Libardo Pantoja
 *
 */
public class GUIFood extends javax.swing.JInternalFrame {

    /**
     * Constructor
     */
    public GUIFood() {
        initComponents();

        setSize(870, 500);
        fijarMensajeExplicacion();
        btnAgregar.setVisible(false);

    }

    /**
     * Mensaje inicial del panel superior
     */
    private void fijarMensajeExplicacion() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("<html>" + "Este ejercicio aplica el patrón cliente/servidor.<br>"
                + "La aplicación cliente se conecta al servidor mediante Sockets.<br>"
                + "El servidor devuelve el objeto Cliente consultado en formato JSON.<br>"
                + "En el backend las cedulas desde 98000001 hasta 98000010.<br>"
                + "</html>");
        lblExplicacion.setText(sb.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlCentro = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        pnlSur = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        pnlNorte = new javax.swing.JPanel();
        lblExplicacion = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta de Clientes");

        pnlCentro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCentro.setLayout(new java.awt.GridLayout(6, 2));

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("*Nombres:");
        pnlCentro.add(lblNombre);
        pnlCentro.add(txtFirstName);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Apellidos:");
        pnlCentro.add(jLabel1);
        pnlCentro.add(txtLastName);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dirección:");
        pnlCentro.add(jLabel2);
        pnlCentro.add(txtAddress);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Celular:");
        pnlCentro.add(jLabel3);
        pnlCentro.add(txtMobile);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Email:");
        pnlCentro.add(jLabel5);
        pnlCentro.add(txtEmail);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("*Sexo (M, F):");
        pnlCentro.add(jLabel6);
        pnlCentro.add(txtGender);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlSur.add(btnAgregar);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cerrar.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSur.add(btnCerrar);

        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pnlNorte.setBorder(new javax.swing.border.MatteBorder(null));
        pnlNorte.setLayout(new java.awt.GridBagLayout());

        lblExplicacion.setText("lblExplicacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlNorte.add(lblExplicacion, gridBagConstraints);

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("Número de identificación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlNorte.add(lblId, gridBagConstraints);

        txtId.setText("98000001");
        txtId.setPreferredSize(new java.awt.Dimension(150, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlNorte.add(txtId, gridBagConstraints);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlNorte.add(btnBuscar, gridBagConstraints);

        getContentPane().add(pnlNorte, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
    public String getTxtyId() {
        return txtId.getText();
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String id = txtId.getText().trim();

        IFoodAccess service = Factory.getInstance().getFoodService();
        // Inyecta la dependencia
        FoodService foodService = new FoodService(service);
        if (id.equals("")) {
            btnAgregar.setVisible(false);
            txtFirstName.requestFocus();
            return;
        }

        Food food;
        try {
            food = foodService.findFood(id);
        } catch (Exception ex) {
            clearControls();
            successMessage(ex.getMessage(), "Atención");
            btnAgregar.setVisible(true);
            return;
        }
        clearControls();
        showData(food);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        IFoodAccess service = Factory.getInstance().getFoodService();
        // Inyecta la dependencia
        FoodService foodService = new FoodService(service);

        Food food = new Food();
        food.setId(Integer.parseInt(txtId.getText()));
        food.setName(txtFirstName.getText());
        food.setType((FoodTypeEnum.valueOf(txtLastName.getText())));
        

        try {
            String response = foodService.createFood(food);
            successMessage("Cliente "+ response + " agregado con éxito.", "Atención");
            clearControls();
            txtId.setText("");
            btnAgregar.setVisible(false);

        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
        }


    }//GEN-LAST:event_btnAgregarActionPerformed
    /**
     * Muestra los datos en el formulario
     *
     * @param food cliente
     */
    private void showData(Food food) {
        txtFirstName.setText(String.valueOf(food.getId()));
        txtLastName.setText(food.getName());
        txtAddress.setText(String.valueOf(food.getType()));
        
    }

    public void clearControls() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        txtMobile.setText("");
        txtEmail.setText("");
        txtGender.setText("");
    }

    public static void main(String[] args) {
        GUIFood gui = new GUIFood();
        gui.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblExplicacion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMobile;
    // End of variables declaration//GEN-END:variables

}
