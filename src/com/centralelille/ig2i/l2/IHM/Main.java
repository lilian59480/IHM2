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
package com.centralelille.ig2i.l2.IHM;

import com.centralelille.ig2i.l2.IHM.vuecontroleur.Accueil;
import com.centralelille.ig2i.l2.IHM.vuecontroleur.ErreurFatale;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Cette classe est la porte d'entrée de notre application
 *
 * @author Hugo & Lilian
 */
public class Main
    {

    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle( "com/centralelille/ig2i/l2/IHM/Bundle" );

    /**
     * Le Main qui est la porte d'entrée
     * Si vrai, dans ce cas on affiche les messages afin
     * de debloquer les problèmes de conceptions
     *
     * @param args Les arguments CLI
     */
    public static void main( String[] args )
        {
        try
            {

            /*
             * On demande a Java de charger le style par default, afin de coller
             * le plus avec celui de l'OS
             */
            try
                {
                UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
                }
            catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex )
                {
                throw new Exception( MessageFormat.format( BUNDLE.getString( "main.impossibleChargerEnv" ), ex.getLocalizedMessage() ), ex.getCause() ); // NOI18N
                }
            /*
             * On recupére les caractéristiques du client.
             * Cela n'a aucun intêret dans ce projet mais c'est bon de savoir
             * lors
             * des tests pourquoi sa va pas.
             */
            System.getProperties().list( System.out );
            /*
             * On creer et affiche le menu, dans le thread correct
             */
            SwingUtilities.invokeLater( () ->
                {
                new Accueil().setVisible( true );
                } );
            }
        catch ( Exception e )
            {
            ErreurFatale ef = new ErreurFatale( e );
            }

        }
    }
