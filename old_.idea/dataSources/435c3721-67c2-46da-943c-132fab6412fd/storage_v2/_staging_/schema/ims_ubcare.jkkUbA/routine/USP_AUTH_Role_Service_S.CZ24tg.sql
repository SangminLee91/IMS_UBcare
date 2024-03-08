create
    definer = ims@`%` procedure USP_AUTH_Role_Service_S(
    v_Role_No int
)
BEGIN
    SELECT A.Svc_No
         , A.Svc_Nm
         , CONCAT((CASE
                       WHEN MenuID LIKE '_000' THEN ''
                       WHEN MenuID LIKE '__00' THEN '└─'
                       WHEN MenuID IS NULL THEN ''
                       ELSE '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└──' END)
        ,' ', A.Svc_Nm) AS Svc_Nm_Depth
         , IFNULL(Svc_Url,'') Svc_Url
         , MenuID
         , (CASE WHEN B.Role_No IS NULL THEN 0 ELSE 1 END) AS Chk
    FROM Role_Service A
             LEFT OUTER JOIN role_dtl B ON A.Svc_No = B.Svc_No AND B.Role_No = v_Role_No
    WHERE A.Del_Stat = 0
    ORDER BY MenuID;

END;
