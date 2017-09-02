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
import java.awt.Component;
import java.text.MessageFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author lilian
 */
public class ErreurNonFatale
    {

    /**
     *
     * @param p
     * @param ex
     */
    public ErreurNonFatale( Component p, Exception ex )
        {
        ex.printStackTrace( System.err );
        JOptionPane.showMessageDialog( p, MessageFormat.format( Main.BUNDLE.getString( "erreurnonfatale.desc" ), ex.getLocalizedMessage() ), Main.BUNDLE.getString( "erreurnonfatale.titre" ), JOptionPane.ERROR_MESSAGE );
        }
    }
