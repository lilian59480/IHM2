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

import static com.centralelille.ig2i.l2.IHM.Main.BUNDLE;
import com.centralelille.ig2i.l2.IHM.modele.Utils;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author lilian
 */
public final class EnregistrementFichier extends JFileChooser
    {

    /**
     *
     */
    private static final long serialVersionUID = 8_341_648L;

    /**
     *
     */
    public EnregistrementFichier()
        {
        this.setDialogType( JFileChooser.SAVE_DIALOG );
        this.setFileFilter( new FileFilter()
            {
            @Override
            public boolean accept( File f )
                {
                if ( !f.canRead() )
                    {
                    return false;
                    }
                if ( f.isDirectory() )
                    {
                    return true;
                    }

                return Utils.isRTFFile( f );
                }

            @Override
            public String getDescription()
                {
                return BUNDLE.getString( "fichier.rtfdescription" ); //NOI18N
                }
            } );

        this.setAcceptAllFileFilterUsed( false );
        }

    @Override
    public String getTypeDescription( File f )
        {
        String extension = Utils.getExtension( f );
        String type = null;

        if ( extension != null )
            {
            if ( extension.equals( Utils.RTF ) )
                {
                type = BUNDLE.getString( "fichier.rtfdescription" ); //NOI18N
                }
            }
        return type;
        }

    }
