
package edu.yu.cs.com1320.project.stage1.impl;
public class DocumentImpl implements Document
{
    @Override
    public int hashCode() 
    {
        int result = uri.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(binaryData);
        return result;
    }
    @Override
    public boolean equals(Document other)
    {
        return this.document.hashCode()==other.hashCode();
    }
}