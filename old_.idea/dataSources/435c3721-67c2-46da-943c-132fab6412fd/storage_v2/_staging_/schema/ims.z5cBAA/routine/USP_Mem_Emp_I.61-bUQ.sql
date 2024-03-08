create
    definer = ims@`%` procedure USP_Mem_Emp_I(IN v_Emp_No varchar(10),
                                              IN v_Emp_Nm varchar(30),
                                              IN v_Emp_Passwd varchar(50),
                                              IN v_Dept_No int,
                                              IN v_Role int,
                                              IN v_AgentKey int,
                                              IN v_Group_Seq varchar(4000))
BEGIN
	DECLARE v_Dept_Nm VARCHAR(50);
	DECLARE v_UserID VARCHAR(20);
	
	INSERT INTO Emp(Emp_No, Organ_No, Emp_Passwd, Emp_Nm, Agent_Key, Dept_No, Role_No)
	VALUES(v_Emp_No, v_Organ_No, SHA2(v_Emp_Passwd, 256), v_Emp_Nm, v_AgentKey, v_Dept_No, v_Role);
	
	SELECT Dept_Nm INTO v_Dept_Nm FROM Dept  WHERE Dept_No = v_Dept_No;
	
	-- Emp_Hist등록
	IF v_AgentKey IS NOT NULL THEN
		INSERT INTO Emp_Hist(Agent_Key, Emp_No, Organ_No, Emp_Nm, Dept_No, Dept_Nm, Apply_Start_Dt, Reg_Dt)
		SELECT v_AgentKey, v_Emp_No, v_Organ_No, v_Emp_Nm, v_Dept_No, v_Dept_Nm, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP;
		
		-- 녹취 계정 등록
		SET v_UserID = RTRIM(LTRIM(ims_ifx.FN_Get_UserID(v_AgentKey)));
		CALL record.sp_User_insert_app(v_UserID,v_Emp_Nm,'9999','I');
		
	END IF;
	
END;

