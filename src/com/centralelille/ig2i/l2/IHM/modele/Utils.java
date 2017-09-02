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
package com.centralelille.ig2i.l2.IHM.modele;

import static com.centralelille.ig2i.l2.IHM.Main.BUNDLE;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author lilian
 */
public class Utils
    {

    /**
     *
     */
    public final static String RTF = BUNDLE.getString( "fichier.rtf" ); //NOI18N

    /**
     *
     * @param f
     *
     * @return
     */
    public static String getExtension( File f )
        {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf( '.' );

        if ( i > 0 && i < s.length() - 1 )
            {
            ext = s.substring( i + 1 ).toLowerCase();
            }
        return ext;
        }

    /**
     *
     * @param f
     *
     * @return
     */
    public static boolean isRTFFile( File f )
        {
        String ext = getExtension( f );
        if ( ext == null )
            {
            return false;
            }
        return ext.equals( RTF );
        }

    /**
     *
     * @param f
     * @param fc
     *
     * @return
     */
    public static File setFichierValide( File f, JFileChooser fc )
        {
        File file = f;
        if ( !file.getAbsolutePath().endsWith( BUNDLE.getString( "fichier.rtfext" ) ) ) //NOI18N
            {
            file = new File( fc.getSelectedFile() + BUNDLE.getString( "fichier.rtfext" ) ); //NOI18N
            }
        return file;
        }

    /**
     *
     */
    private Utils()
        {
        }
    }
