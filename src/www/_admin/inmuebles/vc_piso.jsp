<jsp:useBean id="ofel_piso" class="com.emesa.gestinm.dao.FEL_PISO" scope="session" />
<table cellpadding="2" cellspacing="2" border="0">
    <tr>
    <td valign="top"><table>
        <tr>
            <td><b>Antig&uuml;edad</b>:</td>
            <td><%=ofel_piso.getANTIGUEDAD()%></td>
        </tr>
        <tr>
            <td><b>N<sup>o</sup> dormitorios</b>:</td>
            <td><%=ofel_piso.getDORMITORIOS()%></td>
        </tr>
        <tr>
            <td><b>N<sup>o</sup> ba&ntilde;os</b>:</td>
            <td><%=ofel_piso.getBANOS()%></td>
        </tr>
        <tr>
            <td><b>N<sup>o</sup> aseos</b>:</td>
            <td><%=ofel_piso.getASEOS()%></td>
        </tr>

        <tr>
            <td><b>Calefacci&oacute;n</b>:</td>
            <td><%=ofel_piso.getCALEFACCION()==null?"-":ofel_piso.getCALEFACCION()%></td>
        </tr>
        <tr>
            <td><b>Agua caliente</b>:</td>
            <td><%=ofel_piso.getAGUA_CALIENTE()==null?"-":ofel_piso.getAGUA_CALIENTE()%></td>
        </tr>
        <tr>
            <td><b>Comunidad</b>:</td>
            <td><%=ofel_piso.getGASTOS_COMUNIDAD()==null?" - ":ofel_piso.getGASTOS_COMUNIDAD()%></td>
        </tr>
    </table>
    </td>
    <td width="40"/>
    <td valign="top">
    <table>
        <tr>
            <td><b>Amueblado</b>:</td>
            <td><%=ofel_piso.getAMUEBLADO()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Garaje</b>:</td>
            <td><%=ofel_piso.getGARAJE()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Piscina</b>:</td>
            <td><%=ofel_piso.getPISCINA()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Aire acondicionado</b>:</td>
            <td><%=ofel_piso.getAIRE_ACONDICIONADO()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Cocina amueblada</b>:</td>
            <td><%=ofel_piso.getCOCINA_AMUEBLADA()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Ascensor</b>:</td>
            <td><%=ofel_piso.getASCENSOR()==1?"Si":"No"%></td>
        </tr>
        <tr>
            <td><b>Trastero</b>:</td>
            <td><%=ofel_piso.getTRASTERO()==1?"Si":"No"%></td>
        </tr>
    </table>
    </td>
    </tr>
</table>
