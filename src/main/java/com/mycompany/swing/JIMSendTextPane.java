/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swing;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;


public class JIMSendTextPane extends JTextPane
{

    private Object tag;

    public Object getTag()
    {
        return tag;
    }

    public void setTag(Object tag)
    {
        this.tag = tag;
    }
    // 内部类
    // 以下内部类全都用于实现自动强制折行

    private class WarpEditorKit extends StyledEditorKit
    {

        private ViewFactory defaultFactory = new WarpColumnFactory();

        @Override
        public ViewFactory getViewFactory()
        {
            return defaultFactory;
        }
    }

    private class WarpColumnFactory implements ViewFactory
    {

        @Override
        public View create(Element elem)
        {
            String kind = elem.getName();
            if (kind != null)
            {
                switch (kind) {
                    case AbstractDocument.ContentElementName:
                        return new WarpLabelView(elem);
                    case AbstractDocument.ParagraphElementName:
                        return new ParagraphView(elem);
                    case AbstractDocument.SectionElementName:
                        return new BoxView(elem, View.Y_AXIS);
                    case StyleConstants.ComponentElementName:
                        return new ComponentView(elem);
                    case StyleConstants.IconElementName:
                        return new WarpIconView(elem);
                    default:
                        break;
                }
            }

            // default to text display
            return new LabelView(elem);
        }
    }

    private class WarpLabelView extends LabelView
    {

        public WarpLabelView(Element elem)
        {
            super(elem);
        }

        @Override
        public float getMinimumSpan(int axis)
        {
            switch (axis)
            {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }

    private class WarpIconView extends IconView
    {

        public WarpIconView(Element elem)
        {
            super(elem);
        }

        @Override
        public float getMinimumSpan(int axis)
        {
            switch (axis)
            {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }

    public JIMSendTextPane()
    {
        super();
        this.setEditorKit(new WarpEditorKit());
    }
}