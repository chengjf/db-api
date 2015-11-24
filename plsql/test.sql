PL/SQL Developer Test script 3.0
12
-- CHENGJIANFENG100 创建于 2015-11-24 
declare
  -- 这里是本地变量
  --i integer;
  v_result number;
begin
  -- 这里是测试语句
  chengjf_test.apply_discount(100, 0.9, v_result);
  dbms_output.put_line(v_result);
  v_result := chengjf_test.apply_discountx(100, 0.9);
  dbms_output.put_line(v_result);
end;
0
0
