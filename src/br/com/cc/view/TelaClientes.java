/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.view;

import br.com.cc.dao.ChamadoDao;
import br.com.cc.dao.ClienteDao;
import br.com.cc.model.Chamado;
import br.com.cc.model.Cliente;
import br.com.cc.tableModel.TabelaModeloClientes;
import br.com.cc.utilitarios.SomenteNumeros;
import br.com.cc.utilitarios.Utilitarios;
import javax.swing.JOptionPane;

/**
 *
 * @author alafaria
 */
public class TelaClientes extends javax.swing.JFrame {

    /**
     * Creates new form TelaClientes
     */
    TelaChamados enviar;
    Cliente cliente = new Cliente();
    Chamado chamado = new Chamado();
    ChamadoDao chamadoDao = new ChamadoDao();
    ClienteDao clienteDao = new ClienteDao();
    Utilitarios utilitario = new Utilitarios();

    public TelaClientes() {
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(getToolkit().createImage(getClass().getResource("/imagens/simpress_logo.png")));
        tabelaClientes.setModel(new TabelaModeloClientes(new ClienteDao().listarClientesTabela()));
        btAlterarCliente.setEnabled(false);
        btExcluir.setEnabled(false);
        txtContrato.setDocument(new SomenteNumeros());
        txtConsultaContrato.setDocument(new SomenteNumeros());
    }

    public void atualizarTabelaClientes() {
        tabelaClientes.setModel(new TabelaModeloClientes(new ClienteDao().listarClientesTabela()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtCadastroCliente = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtContrato = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btCadastrarChamado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtConsultaNome = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtConsultaContrato = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btCadastrarCliente = new javax.swing.JButton();
        btAlterarCliente = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de CLientes");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/simpress_logo.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 52)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Cadastro de Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(229, 229, 229)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtCadastroCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtCadastroCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contrato:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nome do Cliente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Endereço:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Contato:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Telefone:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("E-mail:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaCliente.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        jButton1.setText("Limpar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btCadastrarChamado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCadastrarChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cadastro_chamados.png"))); // NOI18N
        btCadastrarChamado.setText("Cadastrar Chamado");
        btCadastrarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarChamadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btCadastrarChamado))
                                    .addComponent(txtNomeCliente)
                                    .addComponent(txtEndereco)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContato)
                                    .addComponent(txtTelefone)
                                    .addComponent(txtEmail))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(92, 92, 92))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(btCadastrarChamado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jtCadastroCliente.addTab("Cadastro de Clientes", jPanel2);

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Por Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtConsultaNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConsultaNomeMouseClicked(evt);
            }
        });
        txtConsultaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsultaNomeKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jLabel11.setText("Nome Cliente:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Por Número do Contrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtConsultaContrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsultaContratoKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pesquisar.png"))); // NOI18N
        jLabel12.setText("Contrato:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(txtConsultaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsultaContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtCadastroCliente.addTab("Consulta de CLientes", jPanel3);

        btCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cadastrar.png"))); // NOI18N
        btCadastrarCliente.setText("Cadastrar");
        btCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarClienteActionPerformed(evt);
            }
        });

        btAlterarCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btAlterarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/alterar.png"))); // NOI18N
        btAlterarCliente.setText("Alterar");
        btAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarClienteActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(btCadastrarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrarCliente)
                    .addComponent(btAlterarCliente)
                    .addComponent(btExcluir)
                    .addComponent(btSair))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarClienteActionPerformed
        // TODO add your handling code here:
        String contrato = txtContrato.getText();
        try {
            if (txtContrato.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo CONTRATO não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else if (txtNomeCliente.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo NOME DO CLIENTE não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else if (txtContato.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo CONTATO não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else if (txtTelefone.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo TELEFONE não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else if (txtEmail.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo E-MAIL não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
            } else {
                Cliente cliente = new Cliente();
                if (txtContrato.getText().equals(cliente.getContrato())) {
                    JOptionPane.showMessageDialog(null, "Número de contrato já existe!");
                } else {
                    cliente.setContrato(Integer.parseInt(txtContrato.getText()));
                    cliente.setNomeCliente(txtNomeCliente.getText());
                    cliente.setEndereco(txtEndereco.getText());
                    cliente.setContato(txtContato.getText());
                    cliente.setTelefone(txtTelefone.getText());
                    cliente.setEmail(txtEmail.getText());
                    clienteDao.cadastrarClientes(contrato, cliente);
                    utilitario.limpaTela(jPanel2);
                    atualizarTabelaClientes();
                    jtCadastroCliente.setSelectedIndex(1);
                    txtContrato.setEnabled(true);
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Usuário!");
            throw new RuntimeException(erro);
        }

    }//GEN-LAST:event_btCadastrarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        utilitario.limpaTela(jPanel2);
        btAlterarCliente.setEnabled(false);
        btExcluir.setEnabled(false);
        btCadastrarCliente.setEnabled(true);
        txtContrato.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        // TODO add your handling code here:
        jtCadastroCliente.setSelectedIndex(0);
        txtContrato.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), TabelaModeloClientes.COLUNA_CONTRATO).toString());
        txtNomeCliente.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), TabelaModeloClientes.COLUNA_NOME).toString());
        txtEndereco.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), TabelaModeloClientes.COLUNA_ENDERECO).toString());
        txtContato.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), TabelaModeloClientes.COLUNA_CONTATO).toString());
        txtTelefone.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), TabelaModeloClientes.COLUNA_TELEFONE).toString());
        txtEmail.setText(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), TabelaModeloClientes.COLUNA_EMAIL).toString());
        btAlterarCliente.setEnabled(true);
        btExcluir.setEnabled(true);
        btCadastrarCliente.setEnabled(false);
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o Cliente?", "Exclusão de Cliente", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            int contrato = Integer.parseInt(txtContrato.getText());
            clienteDao.excluirCliente(contrato);
            atualizarTabelaClientes();
            utilitario.limpaTela(jPanel2);
            btExcluir.setEnabled(false);
            btAlterarCliente.setEnabled(false);
            btCadastrarCliente.setEnabled(true);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarClienteActionPerformed
        // TODO add your handling code here:
        if (txtContrato.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo CONTRATO não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else if (txtNomeCliente.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo NOME DO CLIENTE não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else if (txtContato.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo CONTATO não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo TELEFONE não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo E-MAIL não pode estar em branco!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            cliente.setContrato(Integer.parseInt(txtContrato.getText()));
            cliente.setNomeCliente(txtNomeCliente.getText());
            cliente.setEndereco(txtEndereco.getText());
            cliente.setContato(txtContato.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setEmail(txtEmail.getText());
            clienteDao.alterarCliente(cliente);

            chamado.setContrato(Integer.parseInt(txtContrato.getText()));
            chamado.setNomeCliente(txtNomeCliente.getText());
            chamado.setEndereco(txtEndereco.getText());
            chamado.setContato(txtContato.getText());
            chamado.setTelefone(txtTelefone.getText());
            chamado.setEmail(txtEmail.getText());
            chamadoDao.alterarChamadoConjuntoCliente(chamado);

            utilitario.limpaTela(jPanel2);
            atualizarTabelaClientes();
            btExcluir.setEnabled(false);
            btAlterarCliente.setEnabled(false);
            btCadastrarCliente.setEnabled(true);
            jtCadastroCliente.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btAlterarClienteActionPerformed


    private void txtConsultaNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConsultaNomeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txtConsultaNomeMouseClicked

    private void txtConsultaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaNomeKeyPressed
        // TODO add your handling code here:
        String nome = txtConsultaNome.getText();
        tabelaClientes.setModel(new TabelaModeloClientes(new ClienteDao().listarClientesTabelaPorNome(nome)));
    }//GEN-LAST:event_txtConsultaNomeKeyPressed

    private void txtConsultaContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultaContratoKeyPressed
        // TODO add your handling code here:
        String contrato = txtConsultaContrato.getText();
        tabelaClientes.setModel(new TabelaModeloClientes(new ClienteDao().listarClientesTabelaPorContrato(contrato)));
    }//GEN-LAST:event_txtConsultaContratoKeyPressed

    private void btCadastrarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarChamadoActionPerformed
        // TODO add your handling code here:
        if (txtContrato.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo CONTRATO não pode estar em branco!");
        } else if (txtNomeCliente.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo NOME DO CLIENTE não pode estar em branco!");
        } else if (txtContato.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo CONTATO não pode estar em branco!");
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo TELEFONE não pode estar em branco!");
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Campo E-MAIL não pode estar em branco!");
        } else if (enviar == null) {
            enviar = new TelaChamados();
            enviar.setVisible(true);
            enviar.receberDadosCliente(txtContrato.getText(), txtNomeCliente.getText(), txtEndereco.getText(), txtContato.getText(), txtTelefone.getText(), txtEmail.getText());
            this.dispose();
        }
    }//GEN-LAST:event_btCadastrarChamadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterarCliente;
    private javax.swing.JButton btCadastrarChamado;
    private javax.swing.JButton btCadastrarCliente;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane jtCadastroCliente;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtConsultaContrato;
    private javax.swing.JTextField txtConsultaNome;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtContrato;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    void receberDadosChamadosContrato(String text) {
        txtContrato.setText(text);
        txtContrato.setEnabled(false);
    }
}
