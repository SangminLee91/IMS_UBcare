create
    definer = ims@`%` procedure USP_AUTH_Role_Service_S()
BEGIN
    SELECT Svc_No
         , Svc_Nm
         , CONCAT((CASE
                       WHEN MenuID LIKE '_000' THEN ''
                       WHEN MenuID LIKE '__00' THEN '└─'
                       WHEN MenuID IS NULL THEN ''
                       ELSE '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└──' END)
        ,' ',Svc_Nm) AS Svc_Nm_Depth
         , IFNULL(Svc_Url,'') Svc_Url
         , MenuID
    FROM Role_Service A
    LEFT OUTER JOIN `role` B ON 1=1
    WHERE A.Del_Stat = 0 
    AND B.del_stat = 0
    AND B.Role_No = 1
    GROUP BY svc_no
    ORDER BY MenuID;

END;

