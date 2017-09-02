/*
 * Copyright (C) 2017 Hugo Dooms & Lilian Petitpas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.centralelille.ig2i.l2.IHM.vuecontroleur;

import com.centralelille.ig2i.l2.IHM.Main;
import com.centralelille.ig2i.l2.IHM.modele.Utils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author Hugo & Lilian
 */
public final class FenetreEditeur extends JFrame
    {

    /**
     *
     */
    private static final long serialVersionUID = 25_841_587_425L;

    /**
     *
     */
    private File fichierSource = null;

    /**
     *
     */
    private RTFEditorKit editeur = new RTFEditorKit();

    /**
     *
     */
    private Document document = new DefaultStyledDocument();

    private Font resultatTaille = new Font( "Default", Font.PLAIN, 14 );

    private Color resultatCouleur = Color.BLACK;

    private boolean modified = false;

    /**
     * Creer une fenetre avec le fichier d'exemple ou un fichier vide
     *
     * @param tutoriel
     */
    public FenetreEditeur( boolean tutoriel )
        {
        initComponents();
        if ( tutoriel )
            {
            initEditeurFromTutoriel();
            }
        else
            {
            initEditeurFromDefault();
            }
        createGUI( true );
        }

    /**
     * Creer une fenetre avec un chemin vers le fichier
     *
     * @param fichier Le fichier a lire
     */
    public FenetreEditeur( File fichier )
        {
        initComponents();
        boolean isEditable = true;
        try
            {
            initEditeurFromFichierTexte( fichier );
            this.fichierSource = fichier;
            }
        catch ( NullPointerException | FileNotFoundException e )
            {
            ErreurNonFatale enf = new ErreurNonFatale( this, e );
            isEditable = false;
            }
        createGUI( isEditable );
        }

    /**
     *
     * @param isEditable
     */
    private void createGUI( boolean isEditable )
        {
        this.eltEditeur.setEditable( isEditable );
        setLocationRelativeTo( null );
        resetDocumentListener();
        setVisible( true );
        }

    /**
     *
     */
    private void resetDocumentListener()
        {
        this.eltEditeur.getDocument().addDocumentListener( new DocumentListener()
            {
            @Override
            public void insertUpdate( DocumentEvent e )
                {
                eltEditorModified();
                }

            @Override
            public void removeUpdate( DocumentEvent e )
                {
                eltEditorModified();
                }

            @Override
            public void changedUpdate( DocumentEvent e )
                {
                eltEditorModified();
                }
            } );
        }

    /**
     * Le code qui suit est automatiquement généré par l'éditeur graphique
     * Netbeans.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        eltSplitEditeurOutils = new JSplitPane();
        eltPanelOutils = new JPanel();
        eltLabelOutils = new JLabel();
        eltBarreOutilsGras1 = new JToolBar();
        eltBoutonTaille = new JButton();
        eltBoutonCouleur = new JButton();
        eltBarreOutilsGras = new JToolBar();
        eltBoutonGras = new JToggleButton();
        eltBoutonItalique = new JToggleButton();
        eltBoutonSurligne = new JToggleButton();
        eltBoutonBarre = new JToggleButton();
        eltScrollPane = new JScrollPane();
        eltEditeur = new JTextPane();
        eltLabelStatus = new JLabel();
        eltBarreMenu = new JMenuBar();
        eltFichierMenu = new JMenu();
        eltMenuItemNouveau = new JMenuItem();
        eltMenuItemOuvrir = new JMenuItem();
        eltMenuItemEnregistrer = new JMenuItem();
        eltMenuItemEnregistrerSous = new JMenuItem();
        eltMenuItemQuitter = new JMenuItem();
        eltAideMenu = new JMenu();
        eltMenuItemManuel = new JMenuItem();
        eltMenuItemManuel1 = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(Main.BUNDLE.getString("main.title")); // NOI18N
        setMinimumSize(new Dimension(1024, 768));

        eltSplitEditeurOutils.setDividerLocation(60);
        eltSplitEditeurOutils.setOrientation(JSplitPane.VERTICAL_SPLIT);

        eltPanelOutils.setBackground(new Color(230, 230, 250));

        eltLabelOutils.setText(Main.BUNDLE.getString("editeur.toolbar")); // NOI18N
        eltPanelOutils.add(eltLabelOutils);

        eltBarreOutilsGras1.setRollover(true);
        eltBarreOutilsGras1.setToolTipText(Main.BUNDLE.getString("editeur.ancrable")); // NOI18N

        eltBoutonTaille.setText(Main.BUNDLE.getString("editeur.selectFont")); // NOI18N
        eltBoutonTaille.setFocusable(false);
        eltBoutonTaille.setHorizontalTextPosition(SwingConstants.CENTER);
        eltBoutonTaille.setVerticalTextPosition(SwingConstants.BOTTOM);
        eltBoutonTaille.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                eltBoutonTailleActionPerformed(evt);
            }
        });
        eltBarreOutilsGras1.add(eltBoutonTaille);

        eltBoutonCouleur.setText(Main.BUNDLE.getString("editeur.selectCouleur")); // NOI18N
        eltBoutonCouleur.setFocusable(false);
        eltBoutonCouleur.setHorizontalTextPosition(SwingConstants.CENTER);
        eltBoutonCouleur.setVerticalTextPosition(SwingConstants.BOTTOM);
        eltBoutonCouleur.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                eltBoutonCouleurActionPerformed(evt);
            }
        });
        eltBarreOutilsGras1.add(eltBoutonCouleur);

        eltPanelOutils.add(eltBarreOutilsGras1);

        eltBarreOutilsGras.setRollover(true);

        eltBoutonGras.setText(Main.BUNDLE.getString("editeur.gras.texte")); // NOI18N
        eltBoutonGras.setFocusable(false);
        eltBoutonGras.setHorizontalTextPosition(SwingConstants.CENTER);
        eltBoutonGras.setVerticalTextPosition(SwingConstants.BOTTOM);
        eltBoutonGras.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                eltBoutonGrasActionPerformed(evt);
            }
        });
        eltBarreOutilsGras.add(eltBoutonGras);

        eltBoutonItalique.setText(Main.BUNDLE.getString("editeur.italique.texte")); // NOI18N
        eltBoutonItalique.setFocusable(false);
        eltBoutonItalique.setHorizontalTextPosition(SwingConstants.CENTER);
        eltBoutonItalique.setVerticalTextPosition(SwingConstants.BOTTOM);
        eltBoutonItalique.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                eltBoutonItaliqueActionPerformed(evt);
            }
        });
        eltBarreOutilsGras.add(eltBoutonItalique);

        eltBoutonSurligne.setText(Main.BUNDLE.getString("editeur.surligne.texte")); // NOI18N
        eltBoutonSurligne.setFocusable(false);
        eltBoutonSurligne.setHorizontalTextPosition(SwingConstants.CENTER);
        eltBoutonSurligne.setVerticalTextPosition(SwingConstants.BOTTOM);
        eltBoutonSurligne.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                eltBoutonSurligneActionPerformed(evt);
            }
        });
        eltBarreOutilsGras.add(eltBoutonSurligne);

        eltBoutonBarre.setText(Main.BUNDLE.getString("editeur.barre.texte")); // NOI18N
        eltBoutonBarre.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                eltBoutonBarreActionPerformed(evt);
            }
        });
        eltBarreOutilsGras.add(eltBoutonBarre);

        eltPanelOutils.add(eltBarreOutilsGras);

        eltSplitEditeurOutils.setTopComponent(eltPanelOutils);

        eltEditeur.setContentType("text/rtf"); // NOI18N
        eltEditeur.setDocument(document);
        eltEditeur.setEditorKit(editeur);
        eltEditeur.addMouseListener(new MouseAdapter()
            {
                public void mouseReleased(MouseEvent evt)
                {
                    eltEditeurMouseReleased(evt);
                }
            });
            eltScrollPane.setViewportView(eltEditeur);

            eltSplitEditeurOutils.setBottomComponent(eltScrollPane);

            eltLabelStatus.setHorizontalAlignment(SwingConstants.RIGHT);
            eltLabelStatus.setText(Main.BUNDLE.getString("editeur.status.normal")); // NOI18N

            eltFichierMenu.setText(Main.BUNDLE.getString("editeur.menu.fichier")); // NOI18N

            eltMenuItemNouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
            eltMenuItemNouveau.setText(Main.BUNDLE.getString("editeur.menu.nouveau")); // NOI18N
            eltMenuItemNouveau.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemNouveauActionPerformed(evt);
                }
            });
            eltFichierMenu.add(eltMenuItemNouveau);

            eltMenuItemOuvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
            eltMenuItemOuvrir.setText(Main.BUNDLE.getString("editeur.menu.ouvrir")); // NOI18N
            eltMenuItemOuvrir.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemOuvrirActionPerformed(evt);
                }
            });
            eltFichierMenu.add(eltMenuItemOuvrir);

            eltMenuItemEnregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
            eltMenuItemEnregistrer.setText(Main.BUNDLE.getString("editeur.menu.enregistrer")); // NOI18N
            eltMenuItemEnregistrer.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemEnregistrerActionPerformed(evt);
                }
            });
            eltFichierMenu.add(eltMenuItemEnregistrer);

            eltMenuItemEnregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
            eltMenuItemEnregistrerSous.setText(Main.BUNDLE.getString("editeur.menu.enregistrerSous")); // NOI18N
            eltMenuItemEnregistrerSous.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemEnregistrerSousActionPerformed(evt);
                }
            });
            eltFichierMenu.add(eltMenuItemEnregistrerSous);

            eltMenuItemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
            eltMenuItemQuitter.setText(Main.BUNDLE.getString("editeur.menu.quitter")); // NOI18N
            eltMenuItemQuitter.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemQuitterActionPerformed(evt);
                }
            });
            eltFichierMenu.add(eltMenuItemQuitter);

            eltBarreMenu.add(eltFichierMenu);

            eltAideMenu.setText(Main.BUNDLE.getString("editeur.menu.aide")); // NOI18N

            eltMenuItemManuel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
            eltMenuItemManuel.setText(Main.BUNDLE.getString("editeur.menu.tutoriel")); // NOI18N
            eltMenuItemManuel.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemManuelActionPerformed(evt);
                }
            });
            eltAideMenu.add(eltMenuItemManuel);

            eltMenuItemManuel1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
            eltMenuItemManuel1.setText(Main.BUNDLE.getString("editeur.menu.apropos")); // NOI18N
            eltMenuItemManuel1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    eltMenuItemManuel1ActionPerformed(evt);
                }
            });
            eltAideMenu.add(eltMenuItemManuel1);

            eltBarreMenu.add(eltAideMenu);

            setJMenuBar(eltBarreMenu);

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(eltSplitEditeurOutils, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(eltLabelStatus, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(eltSplitEditeurOutils, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(eltLabelStatus)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void eltBoutonTailleActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltBoutonTailleActionPerformed
    {//GEN-HEADEREND:event_eltBoutonTailleActionPerformed
        JDialog taille = new FenetreDTaille( this );
        if ( isModified() )
            {
            int start = this.eltEditeur.getSelectionStart();
            int end = this.eltEditeur.getSelectionEnd();
            setState( StyleConstants.FontFamily, this.resultatTaille.getFamily(), start, end );
            setState( StyleConstants.FontSize, this.resultatTaille.getSize(), start, end );
            setModified( false );
            }

    }//GEN-LAST:event_eltBoutonTailleActionPerformed

    private void eltBoutonCouleurActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltBoutonCouleurActionPerformed
    {//GEN-HEADEREND:event_eltBoutonCouleurActionPerformed
        JDialog couleur = new FenetreDCouleur( this );
        int start = this.eltEditeur.getSelectionStart();
        int end = this.eltEditeur.getSelectionEnd();
        if ( isModified() )
            {
            setState( StyleConstants.Foreground, this.resultatCouleur, start, end );
            setModified( false );
            }
    }//GEN-LAST:event_eltBoutonCouleurActionPerformed

    private void eltBoutonGrasActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltBoutonGrasActionPerformed
    {//GEN-HEADEREND:event_eltBoutonGrasActionPerformed
        System.out.println( Main.BUNDLE.getString( "editeur.gras.tooltip" ) );
        int start = this.eltEditeur.getSelectionStart();
        int end = this.eltEditeur.getSelectionEnd();
        setState( StyleConstants.Bold, this.eltBoutonGras.isSelected(), start, end );
    }//GEN-LAST:event_eltBoutonGrasActionPerformed

    private void eltBoutonItaliqueActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltBoutonItaliqueActionPerformed
    {//GEN-HEADEREND:event_eltBoutonItaliqueActionPerformed
        System.out.println( Main.BUNDLE.getString( "editeur.italique.tooltip" ) );
        int start = this.eltEditeur.getSelectionStart();
        int end = this.eltEditeur.getSelectionEnd();
        setState( StyleConstants.Italic, this.eltBoutonItalique.isSelected(), start, end );
    }//GEN-LAST:event_eltBoutonItaliqueActionPerformed

    private void eltBoutonSurligneActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltBoutonSurligneActionPerformed
    {//GEN-HEADEREND:event_eltBoutonSurligneActionPerformed
        System.out.println( Main.BUNDLE.getString( "editeur.souligne.tooltip" ) );
        int start = this.eltEditeur.getSelectionStart();
        int end = this.eltEditeur.getSelectionEnd();
        setState( StyleConstants.Underline, this.eltBoutonSurligne.isSelected(), start, end );
    }//GEN-LAST:event_eltBoutonSurligneActionPerformed

    private void eltBoutonBarreActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltBoutonBarreActionPerformed
    {//GEN-HEADEREND:event_eltBoutonBarreActionPerformed
        System.out.println( Main.BUNDLE.getString( "editeur.barre.tooltip" ) );
        int start = this.eltEditeur.getSelectionStart();
        int end = this.eltEditeur.getSelectionEnd();
        setState( StyleConstants.StrikeThrough, this.eltBoutonBarre.isSelected(), start, end );
    }//GEN-LAST:event_eltBoutonBarreActionPerformed

    private void eltMenuItemNouveauActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemNouveauActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemNouveauActionPerformed
        int resultat = JOptionPane.showConfirmDialog( this, Main.BUNDLE.getString( "editeur.dialog.enregistrer" ), Main.BUNDLE.getString( "editeur.dialog.titre" ), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
        if ( resultat == JOptionPane.OK_OPTION )
            {
            enregistrer();
            }
        this.fichierSource = null;
        initEditeurFromDefault();
    }//GEN-LAST:event_eltMenuItemNouveauActionPerformed

    private void eltMenuItemEnregistrerActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemEnregistrerActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemEnregistrerActionPerformed
        enregistrer();
    }//GEN-LAST:event_eltMenuItemEnregistrerActionPerformed

    private void eltMenuItemEnregistrerSousActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemEnregistrerSousActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemEnregistrerSousActionPerformed
        enregistrerSous();
    }//GEN-LAST:event_eltMenuItemEnregistrerSousActionPerformed

    private void eltMenuItemOuvrirActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemOuvrirActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemOuvrirActionPerformed
        ChoixFichier fc = new ChoixFichier();
        int returnVal = fc.showOpenDialog( this );

        if ( returnVal == JFileChooser.APPROVE_OPTION )
            {
            try
                {
                File file = fc.getSelectedFile();
                initEditeurFromFichierTexte( file );
                this.eltEditeur.setEditable( true );
                }
            catch ( NullPointerException | FileNotFoundException e )
                {
                ErreurNonFatale enf = new ErreurNonFatale( this, e );
                this.eltEditeur.setEditable( false );
                }
            }
    }//GEN-LAST:event_eltMenuItemOuvrirActionPerformed

    private void eltMenuItemManuelActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemManuelActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemManuelActionPerformed
        int resultat = JOptionPane.showConfirmDialog( this, Main.BUNDLE.getString( "editeur.dialog.enregistrer" ), Main.BUNDLE.getString( "editeur.dialog.titre" ), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
        if ( resultat == JOptionPane.OK_OPTION )
            {
            enregistrer();
            }
        this.fichierSource = null;
        initEditeurFromTutoriel();
    }//GEN-LAST:event_eltMenuItemManuelActionPerformed

    private void eltMenuItemQuitterActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemQuitterActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemQuitterActionPerformed
        int resultat = JOptionPane.showConfirmDialog( this, Main.BUNDLE.getString( "editeur.dialog.enregistrer" ), Main.BUNDLE.getString( "editeur.dialog.titre" ), JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE );
        if ( resultat == JOptionPane.OK_OPTION )
            {
            enregistrer();
            }
        this.dispose();
    }//GEN-LAST:event_eltMenuItemQuitterActionPerformed

    private void eltMenuItemManuel1ActionPerformed(ActionEvent evt)//GEN-FIRST:event_eltMenuItemManuel1ActionPerformed
    {//GEN-HEADEREND:event_eltMenuItemManuel1ActionPerformed
        JOptionPane.showMessageDialog( this, Main.BUNDLE.getString( "editeur.apropos" ), Main.BUNDLE.getString( "editeur.menu.apropos" ), JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_eltMenuItemManuel1ActionPerformed

    private void eltEditeurMouseReleased( MouseEvent evt )
        {
        if ( this.eltEditeur.getCharacterAttributes().containsAttribute( StyleConstants.StrikeThrough, true ) )
            {
            this.eltBoutonBarre.setSelected( true );
            }
        else
            {
            this.eltBoutonBarre.setSelected( false );
            }

        if ( this.eltEditeur.getCharacterAttributes().containsAttribute( StyleConstants.Underline, true ) )
            {
            this.eltBoutonSurligne.setSelected( true );
            }
        else
            {
            this.eltBoutonSurligne.setSelected( false );
            }
        if ( this.eltEditeur.getCharacterAttributes().containsAttribute( StyleConstants.Italic, true ) )
            {
            this.eltBoutonItalique.setSelected( true );
            }
        else
            {
            this.eltBoutonItalique.setSelected( false );
            }
        if ( this.eltEditeur.getCharacterAttributes().containsAttribute( StyleConstants.Bold, true ) )
            {
            this.eltBoutonGras.setSelected( true );
            }
        else
            {
            this.eltBoutonGras.setSelected( false );
            }
        }

    /**
     *
     */
    private void eltEditorModified()
        {
        this.eltLabelStatus.setText( Main.BUNDLE.getString( "editeur.status.modifie" ) );
        }

    /*
     *
     */
    private void setState( Object nom, Object valeur, int start, int end )
        {
        int realend = end;
        if ( start == end )
            {
            realend++;
            }
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet asset = sc.addAttribute( SimpleAttributeSet.EMPTY, nom, valeur );
        this.eltEditeur.getStyledDocument().setCharacterAttributes( start, realend - start, asset, false );
        if ( start == end )
            {
            realend--;
            }
        this.eltEditeur.requestFocus();
        this.eltEditeur.setSelectionStart( start );
        this.eltEditeur.setSelectionEnd( end );
        }

    /**
     *
     */
    private void initEditeurFromTutoriel()
        {
        InputStreamReader is = new InputStreamReader( Main.class.getClassLoader().getResourceAsStream( Main.BUNDLE.getString( "fichier.tutoriel" ) ), StandardCharsets.UTF_8 );
        try
            {
            this.editeur.read( is, this.eltEditeur.getDocument(), 0 );
            resetDocumentListener();
            }
        catch ( IOException | BadLocationException ex )
            {
            ErreurFatale ef = new ErreurFatale( this, ex );
            }
        }

    /**
     *
     * @param fichier
     *
     * @throws NullPointerException
     * @throws FileNotFoundException
     */
    private void initEditeurFromFichierTexte( File fichier ) throws NullPointerException, FileNotFoundException
        {
        InputStreamReader is;
        is = new InputStreamReader( new FileInputStream( fichier ) );
        try
            {
            this.editeur.read( is, this.eltEditeur.getDocument(), 0 );
            resetDocumentListener();
            }
        catch ( IOException | BadLocationException ex )
            {
            ErreurFatale ef = new ErreurFatale( ex );
            }
        }

    /**
     *
     */
    private void initEditeurFromDefault()
        {
        this.eltEditeur.setDocument( this.editeur.createDefaultDocument() );
        resetDocumentListener();
        }

    /**
     *
     */
    private void enregistrer()
        {
        if ( this.fichierSource == null )
            {
            enregistrerSous();
            }
        else
            {
            ecrireFichier( fichierSource );
            }
        }

    /**
     *
     */
    private void enregistrerSous()
        {
        EnregistrementFichier fc = new EnregistrementFichier();
        int returnVal = fc.showSaveDialog( this );

        if ( returnVal == JFileChooser.APPROVE_OPTION )
            {
            File file = fc.getSelectedFile();
            ecrireFichier( Utils.setFichierValide( file, fc ) );
            this.fichierSource = file;
            }
        }

    /**
     *
     * @param f
     */
    private void ecrireFichier( File f )
        {
        try ( OutputStream osf = new FileOutputStream( f ) )
            {
            Document d = this.eltEditeur.getDocument();
            this.eltEditeur.getEditorKit().write( osf, d, 0, d.getLength() );
            this.eltLabelStatus.setText( Main.BUNDLE.getString( "editeur.status.enregistre" ) );
            }
        catch ( IOException | BadLocationException ex )
            {
            ErreurNonFatale enf = new ErreurNonFatale( this, ex );
            }
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JMenu eltAideMenu;
    private JMenuBar eltBarreMenu;
    private JToolBar eltBarreOutilsGras;
    private JToolBar eltBarreOutilsGras1;
    private JToggleButton eltBoutonBarre;
    private JButton eltBoutonCouleur;
    private JToggleButton eltBoutonGras;
    private JToggleButton eltBoutonItalique;
    private JToggleButton eltBoutonSurligne;
    private JButton eltBoutonTaille;
    private JTextPane eltEditeur;
    private JMenu eltFichierMenu;
    private JLabel eltLabelOutils;
    private JLabel eltLabelStatus;
    private JMenuItem eltMenuItemEnregistrer;
    private JMenuItem eltMenuItemEnregistrerSous;
    private JMenuItem eltMenuItemManuel;
    private JMenuItem eltMenuItemManuel1;
    private JMenuItem eltMenuItemNouveau;
    private JMenuItem eltMenuItemOuvrir;
    private JMenuItem eltMenuItemQuitter;
    private JPanel eltPanelOutils;
    private JScrollPane eltScrollPane;
    private JSplitPane eltSplitEditeurOutils;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the resultatTaille
     */
    public Font getResultatTaille()
        {
        return resultatTaille;
        }

    /**
     * @param resultatTaille the resultatTaille to set
     */
    public void setResultatTaille( Font resultatTaille )
        {
        this.resultatTaille = resultatTaille;
        }

    /**
     * @return the resultatCouleur
     */
    public Color getResultatCouleur()
        {
        return resultatCouleur;
        }

    /**
     * @param resultatCouleur the resultatCouleur to set
     */
    public void setResultatCouleur( Color resultatCouleur )
        {
        this.resultatCouleur = resultatCouleur;
        }

    /**
     * @return the modified
     */
    public boolean isModified()
        {
        return modified;
        }

    /**
     * @param modified the modified to set
     */
    public void setModified( boolean modified )
        {
        this.modified = modified;
        }

    }
