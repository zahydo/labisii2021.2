package co.edu.unicauca.commandrestaurant.presentation;

import co.edu.unicauca.commandrestaurant.domain.CreateCommand;
import co.edu.unicauca.commandrestaurant.domain.Food;
import javax.swing.table.DefaultTableModel;
import co.edu.unicauca.commandrestaurant.domain.Invoker;
import co.edu.unicauca.commandrestaurant.domain.FindAllCommand;
import co.edu.unicauca.commandrestaurant.domain.FindByIdCommand;
import co.edu.unicauca.commandrestaurant.domain.FoodTypeEnum;
import co.edu.unicauca.commandrestaurant.domain.RemoveCommand;
import co.edu.unicauca.commandrestaurant.domain.UpdateCommand;
import co.unicauca.commandRestaurant.infra.Messages;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 * Interfaz gráfica de Consultar clientes
 *
 * @author Libardo Pantoja, Daniel Paz
 *
 */
public class GUIFood extends javax.swing.JFrame {

    /**
     * Instancia del invocador para poder enviar comandos al receptor
     * FoodService
     */
    private final Invoker invoker;

    /**
     * Constructor
     */
    public GUIFood() {
        invoker = new Invoker();
        initComponents();
        setSize(870, 300);
        loadDataTable();
        loadDataCombo();
        initStateButtons();
        setLocationRelativeTo(null);

    }

    /**
     * Carga los tipos de comida en el jComboBox
     */
    private void loadDataCombo() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (FoodTypeEnum ft : FoodTypeEnum.values()) {
            model.addElement(ft);
        }
        cboType.setModel(model);
    }

    /**
     * Poner los botones en su estado inicial
     */
    private void initStateButtons() {
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUndo.setEnabled(invoker.hasCommandUndo());
    }

    /**
     * Carga las comidas en el jTable
     */
    private void loadDataTable() {
        invoker.setCommand(new FindAllCommand());
        invoker.execute();
        FindAllCommand findAllCommand = (FindAllCommand) invoker.getCommand();

        List<Food> components = findAllCommand.getFoods();
        DefaultTableModel modelTable = (DefaultTableModel) tblData.getModel();
        clearData(modelTable);
        components.stream().map(component -> {
            Object[] fila = new Object[3];
            fila[0] = component.getId();
            fila[1] = component.getName();
            fila[2] = component.getType().toString();
            return fila;
        }).forEachOrdered(fila -> {
            modelTable.addRow(fila);
        });
    }

    /**
     * Elimina las filas del jTable
     *
     * @param modelTable modelo de datos del jTable
     */
    private void clearData(DefaultTableModel modelTable) {
        while (modelTable.getRowCount() > 0) {
            modelTable.removeRow(0);
        }
    }

    /**
     * Mensaje inicial del panel superior
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        pnlSur = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUndo = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pnlEste = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setTitle("Comidas del Menú Diario");

        pnlCentro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCentro.setLayout(new java.awt.GridLayout(3, 2));

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("*Id:");
        pnlCentro.add(lblId);

        txtId.setPreferredSize(new java.awt.Dimension(150, 32));
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        pnlCentro.add(txtId);

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("*Nombre:");
        pnlCentro.add(lblName);
        pnlCentro.add(txtName);

        lblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblType.setText("*Tipo:");
        pnlCentro.add(lblType);

        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INPUT", "JUICE", "PRINCIPIO" }));
        pnlCentro.add(cboType);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pnlSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlSur.add(btnAdd);

        btnUpdate.setText("Modificar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlSur.add(btnUpdate);

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlSur.add(btnDelete);

        btnUndo.setText("Deshacer");
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        pnlSur.add(btnUndo);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        pnlSur.add(btnClose);

        getContentPane().add(pnlSur, java.awt.BorderLayout.SOUTH);

        pnlEste.setBorder(new javax.swing.border.MatteBorder(null));
        pnlEste.setLayout(new java.awt.BorderLayout());

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblData);

        pnlEste.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlEste, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    public String getTxtyId() {
        return txtId.getText();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtName.getText();
        if (name.isEmpty()) {
            Messages.warningMessage("Debe agregar un nombre", "Atención");
            txtName.requestFocus();
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        String type = cboType.getSelectedItem().toString();
        FoodTypeEnum foodTpye = FoodTypeEnum.valueOf(type);

        addFood(id, name, foodTpye);

        Messages.successMessage("Comida agregada con éxito", "Atención");
        clearControls();
        initStateButtons();
        loadDataTable();

    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Llama a la logica de negocio para agregar comida mediante el comando
     *
     * @param id identificador de la comida
     * @param name nombre de la comida
     * @param type tipo de comida
     */
    private void addFood(int id, String name, FoodTypeEnum type) {
        Food foodComponent = new Food(id, name, type);

        //Fija el comando del invoker
        invoker.setCommand(new CreateCommand(foodComponent));
        //Ejecuta el comando
        invoker.execute();
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = txtName.getText();
        if (name.isEmpty()) {
            Messages.warningMessage("Debe agregar un nombre", "Atención");
            txtName.requestFocus();
            return;
        }
        // Preparar los datos
        int id = Integer.parseInt(txtId.getText());
        String type = cboType.getSelectedItem().toString();
        FoodTypeEnum foodTpye = FoodTypeEnum.valueOf(type);

        // Crea la comida con los nuevos datos
        Food food = new Food(id, name, foodTpye);

        // Traer la comida previa        
        invoker.setCommand(new FindByIdCommand());
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(id);
        invoker.execute();
        //La comida previa debe crearse en una nueva instancia
        Food compAux = findByIdCommand.getFood();
        Food previous = new Food(compAux.getId(), compAux.getName(), compAux.getType());

        //Modifica la comida y guarda el previo
        updateFood(food, previous);

        Messages.successMessage("Comida modificada con éxito", "Atención");
        clearControls();
        initStateButtons();
        loadDataTable();
    }//GEN-LAST:event_btnUpdateActionPerformed
    /**
     * Llama a la logica de negocio para modificar comida mediante el comando
     *
     * @param food comida a editar
     * @param previous comida antes de ser modificada
     */
    private void updateFood(Food food, Food previous) {
        //Fija el UpdateCommand
        invoker.setCommand(new UpdateCommand(food));
        UpdateCommand updateCommand = (UpdateCommand) invoker.getCommand();
        //Fija al comida previa
        updateCommand.setFoodPrevious(previous);
        //Ejecuta el comando
        invoker.execute();
    }

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        String strId = txtId.getText().trim();
        if (strId.isEmpty()) {
            return;
        }

        //Fija el comando del invoker para buscar comida por id
        invoker.setCommand(new FindByIdCommand());
        //Pasa parámetros al comando
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(Integer.parseInt(strId));
        //Ejecuta el comando
        invoker.execute();
        Food food = findByIdCommand.getFood();

        if (food == null) {
            //Agregar
            btnAdd.setEnabled(true);
            btnUndo.setEnabled(false);

        } else {
            //Editar
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnUndo.setEnabled(false);
            txtName.setText(food.getName());
            cboType.setSelectedItem(food.getType().toString());
        }

    }//GEN-LAST:event_txtIdFocusLost

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        //Ejecuta el comando deshacer
        invoker.undo();
        loadDataTable();
        initStateButtons();
    }//GEN-LAST:event_btnUndoActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtIdFocusLost(null);
            txtName.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int id = Integer.parseInt(txtId.getText());
        
        // Traer la comida previa        
        invoker.setCommand(new FindByIdCommand());
        FindByIdCommand findByIdCommand = (FindByIdCommand) invoker.getCommand();
        findByIdCommand.setFoodId(id);
        invoker.execute();
        //La comida previa debe crearse en una nueva instancia
        Food compAux = findByIdCommand.getFood();
        Food previous = new Food(compAux.getId(), compAux.getName(), compAux.getType());
        
        invoker.setCommand(new RemoveCommand(id));
        RemoveCommand removeCommand = (RemoveCommand) invoker.getCommand();
        removeCommand.setFoodPrevious(previous);
        invoker.execute();
        
        Messages.successMessage("Comida eliminada con éxito", "Atención");
        clearControls();
        initStateButtons();
        loadDataTable();
    }//GEN-LAST:event_btnDeleteActionPerformed


    /**
     * Limpia las cajas de texto
     */
    public void clearControls() {
        txtId.setText("");
        txtName.setText("");
        cboType.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        GUIFood gui = new GUIFood();
        gui.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUndo;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlEste;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}
