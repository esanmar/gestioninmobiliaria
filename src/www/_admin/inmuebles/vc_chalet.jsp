<jsp:useBean id="ofel_chalet" class="com.emesa.gestinm.dao.FEL_CHALET" scope="session" />
<table cellpadding="2" cellspacing="2" border="0">
    <tr>
    <td valign="top"><table>
        <tr>
            <td><b>Antig&uuml;edad</b>:</td>
            <td><%=ofel_chalet.getANTIGUEDAD()%></td>
        </tr>
        <tr>
            <td><b>N<sup>o</sup> dormitorios</b>:</td>
            <td><%=ofel_chalet.getDORMITORIOS()%></td>
        </tr>
        <tr>
            <td><b>N<sup>o</sup> ba&ntilde;os</b>:</td>
            <td><%=ofel_chalet.getBANOS()%></td>
        </tr>
        <tr>
            <td><b>N<sup>o</sup> aseos</b>:</td>
            <td><%=ofel_chalet.getASEOS()%></td>
        </tr>
        <tr>
            <td><b>Calefacci&oacute;n</b>:</td>
            <td><%=ofel_chalet.getCALEFACCION()==null?"-":ofel_chalet.getCALEFACCION()%></td>
        </tr>
        <tr>
            <td><b>Agua caliente</b>:</td>
            <td><%=ofel_chalet.getAGUA_CALIENTE()==null?"-":ofel_chalet.getAGUA_CALIENTE()%></td>
        </tr>
    </table>
    </td>
    <td width="40"/>
    <td valign="top">
    <table>
        <tr>
            <td><b>Amueblado</b>:</td>
            <td><%=ofel_chalet.getAMUEBLADO()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Garaje</b>:</td>
            <td><%=ofel_chalet.getGARAJE()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Piscina</b>:</td>
            <td><%=ofel_chalet.getPISCINA()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Aire acondicionado</b>:</td>
            <td><%=ofel_chalet.getAIRE_ACONDICIONADO()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Cocina amueblada</b>:</td>
            <td><%=ofel_chalet.getCOCINA_AMUEBLADA()==1?"Si":"No"%></td>
        </tr>
    </table>
    </td>
    </tr>
</table>
