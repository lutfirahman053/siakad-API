/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.*;
import Kelas.mahasiswa;

/**
 *
 * @author hp
 */
public class FrameProfile extends javax.swing.JFrame {

    /**
     * Creates new form FrameProfile
     */
    public FrameProfile() {
        initComponents();
        loadProfile();
    }
    
  
    void loadProfile() {
        tFoto.setIcon(null);
        JSONArray data = mahasiswa.getDataMhs();
        for (int i = 0; i < data.length(); i++) {
            JSONObject item = data.getJSONObject(i);
            if (i == mahasiswa.getBaris()) {
                Tnim.setText(item.getString("mhs_nim"));
                Tnama.setText(item.getString("mhs_nama"));
                Tjk.setText(item.getString("mhs_jk"));
                Tttl.setText(item.getString("mhs_tempatlahir") + "," + item.getString("mhs_tanggallahir"));
                Temail.setText(item.getString("mhs_email"));
                Thp.setText(item.getString("mhs_hp"));

                if (item.has("mhs_foto") && !item.isNull("mhs_foto") && !item.getString("mhs_foto").isEmpty()) {
                    String dataFoto = item.getString("mhs_foto");

                    try {
                        if (dataFoto.startsWith("data:image")) {
                            String base64Data = dataFoto.split(",")[1];
                            byte[] imageBytes = Base64.getDecoder().decode(base64Data);
                            ByteArrayInputStream bas = new ByteArrayInputStream(imageBytes);
                            BufferedImage bmg = ImageIO.read(bas);
                            Image image = bmg.getScaledInstance(tFoto.getWidth(), tFoto.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon imic = new ImageIcon(image);
                            tFoto.setText(null);
                            tFoto.setIcon(imic);
                        } else {
                            URL url = new URL(dataFoto);
                            BufferedImage bmg = ImageIO.read(url);
                            Image image = bmg.getScaledInstance(tFoto.getWidth(), tFoto.getHeight(), Image.SCALE_SMOOTH);
                            ImageIcon imic = new ImageIcon(image);
                            tFoto.setText(null);
                            tFoto.setIcon(imic);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        tFoto.setText("Foto kosong");
                    }
                } else {
                    tFoto.setText("kosong");
                }

            }

        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tnama = new javax.swing.JTextField();
        Tnim = new javax.swing.JTextField();
        Tjk = new javax.swing.JTextField();
        Tttl = new javax.swing.JTextField();
        Temail = new javax.swing.JTextField();
        Thp = new javax.swing.JTextField();
        tFoto = new javax.swing.JLabel();
        Bclose = new javax.swing.JButton();
        Bnext = new javax.swing.JButton();
        Bprevious = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NAMA");

        jLabel2.setText("NIM");

        jLabel3.setText("JENIS KELAMIN");

        jLabel4.setText("TTL");

        jLabel5.setText("EMAIL");

        jLabel6.setText("HP");

        Tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnamaActionPerformed(evt);
            }
        });

        Tttl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TttlActionPerformed(evt);
            }
        });

        Temail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemailActionPerformed(evt);
            }
        });

        Thp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThpActionPerformed(evt);
            }
        });

        tFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        Bclose.setText("CLOSE");
        Bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcloseActionPerformed(evt);
            }
        });

        Bnext.setText("NEXT");
        Bnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnextActionPerformed(evt);
            }
        });

        Bprevious.setText("PREVIOUS");
        Bprevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(Bprevious, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(Bnext, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(Bclose, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(225, 225, 225))
                    .addComponent(Tnama, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tnim, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tjk)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(Tttl)
                    .addComponent(Temail)
                    .addComponent(Thp)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(Tttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(Temail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(Thp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bclose)
                    .addComponent(Bnext)
                    .addComponent(Bprevious))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcloseActionPerformed
        dispose();
    }//GEN-LAST:event_BcloseActionPerformed

    private void BnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnextActionPerformed
         if(mahasiswa.getBaris()>=0 && mahasiswa.getBaris()<=mahasiswa.getDataMhs().length()){
            mahasiswa.setBaris(mahasiswa.getBaris()+1);
            loadProfile();
        }
    }//GEN-LAST:event_BnextActionPerformed

    private void BpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpreviousActionPerformed
        if(mahasiswa.getBaris()>0 && mahasiswa.getBaris()<=mahasiswa.getDataMhs().length()){
            mahasiswa.setBaris(mahasiswa.getBaris()-1);
            loadProfile();
        }

    }//GEN-LAST:event_BpreviousActionPerformed

    private void TnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TnamaActionPerformed

    private void TttlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TttlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TttlActionPerformed

    private void TemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemailActionPerformed

    private void ThpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThpActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bclose;
    private javax.swing.JButton Bnext;
    private javax.swing.JButton Bprevious;
    private javax.swing.JTextField Temail;
    private javax.swing.JTextField Thp;
    private javax.swing.JTextField Tjk;
    private javax.swing.JTextField Tnama;
    private javax.swing.JTextField Tnim;
    private javax.swing.JTextField Tttl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel tFoto;
    // End of variables declaration//GEN-END:variables
}
