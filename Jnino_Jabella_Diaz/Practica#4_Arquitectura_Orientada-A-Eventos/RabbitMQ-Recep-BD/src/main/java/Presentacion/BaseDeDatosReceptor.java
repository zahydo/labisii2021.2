package Presentacion;

import Dominio.Product;
import infra.Observer;
import Dominio.servicios.ServiceModel;
import javax.swing.DefaultListModel;

/**
 * Es un observador
 *
 * @author ahurtado
 */
public class BaseDeDatosReceptor extends javax.swing.JFrame implements Observer {

    ServiceModel service;
    DefaultListModel modelList;

    /**
     * Creates new form GUIListadoProductos
     *
     * @param service servicio
     */
    public BaseDeDatosReceptor(ServiceModel service) {
        initComponents();
        this.service = service;
        this.modelList = new DefaultListModel();
        lstProducts.setModel(modelList);

        setSize(500, 200);
        setLocation(10, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Base de Datos - Receptor");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        lstProducts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProducts);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstProducts;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Object o) {
        this.setVisible(true);
        modelList.removeAllElements();
        for (Product p : service.listProducts()) {
            modelList.addElement("ID: "+p.getProductId() + " Nombre: " +  p.getName() + " Precio: $" + p.getPrice());
        }

    }
}
