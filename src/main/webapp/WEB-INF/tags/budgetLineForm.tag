<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="CreateBudgetLine" method="post">

    <label>Codi presupost:</label>
    <input type="text" name="code"><br>
    <label>Nom:</label>
    <input type="text" name="name"><br>
    <label>Unitats:</label>
    <input type="text" name="units"><br>
    <label>Preu:</label>
    <input type="text" name="price"><br>

    <input type="submit" value="Afegir!">

</form>