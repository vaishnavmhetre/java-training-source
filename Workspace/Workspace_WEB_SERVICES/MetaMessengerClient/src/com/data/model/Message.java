/**
 * Message.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.data.model;

public class Message  implements java.io.Serializable {
    private java.lang.String content;

    private java.util.Calendar created_at;

    private int id;

    private java.util.Calendar read_at;

    private int receiver_id;

    private int sender_id;

    public Message() {
    }

    public Message(
           java.lang.String content,
           java.util.Calendar created_at,
           int id,
           java.util.Calendar read_at,
           int receiver_id,
           int sender_id) {
           this.content = content;
           this.created_at = created_at;
           this.id = id;
           this.read_at = read_at;
           this.receiver_id = receiver_id;
           this.sender_id = sender_id;
    }


    /**
     * Gets the content value for this Message.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this Message.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the created_at value for this Message.
     * 
     * @return created_at
     */
    public java.util.Calendar getCreated_at() {
        return created_at;
    }


    /**
     * Sets the created_at value for this Message.
     * 
     * @param created_at
     */
    public void setCreated_at(java.util.Calendar created_at) {
        this.created_at = created_at;
    }


    /**
     * Gets the id value for this Message.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Message.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the read_at value for this Message.
     * 
     * @return read_at
     */
    public java.util.Calendar getRead_at() {
        return read_at;
    }


    /**
     * Sets the read_at value for this Message.
     * 
     * @param read_at
     */
    public void setRead_at(java.util.Calendar read_at) {
        this.read_at = read_at;
    }


    /**
     * Gets the receiver_id value for this Message.
     * 
     * @return receiver_id
     */
    public int getReceiver_id() {
        return receiver_id;
    }


    /**
     * Sets the receiver_id value for this Message.
     * 
     * @param receiver_id
     */
    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }


    /**
     * Gets the sender_id value for this Message.
     * 
     * @return sender_id
     */
    public int getSender_id() {
        return sender_id;
    }


    /**
     * Sets the sender_id value for this Message.
     * 
     * @param sender_id
     */
    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Message)) return false;
        Message other = (Message) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.created_at==null && other.getCreated_at()==null) || 
             (this.created_at!=null &&
              this.created_at.equals(other.getCreated_at()))) &&
            this.id == other.getId() &&
            ((this.read_at==null && other.getRead_at()==null) || 
             (this.read_at!=null &&
              this.read_at.equals(other.getRead_at()))) &&
            this.receiver_id == other.getReceiver_id() &&
            this.sender_id == other.getSender_id();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getCreated_at() != null) {
            _hashCode += getCreated_at().hashCode();
        }
        _hashCode += getId();
        if (getRead_at() != null) {
            _hashCode += getRead_at().hashCode();
        }
        _hashCode += getReceiver_id();
        _hashCode += getSender_id();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Message.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.data.com", "Message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.data.com", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("created_at");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.data.com", "created_at"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.data.com", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("read_at");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.data.com", "read_at"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiver_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.data.com", "receiver_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.data.com", "sender_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
