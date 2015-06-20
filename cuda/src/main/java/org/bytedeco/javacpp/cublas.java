// Targeted by JavaCPP version 1.0-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.cuda.*;

public class cublas extends org.bytedeco.javacpp.presets.cublas {
    static { Loader.load(); }

// Parsed from <cublas_api.h>

/*
 * Copyright 1993-2014 NVIDIA Corporation.  All rights reserved.
 *
 * NOTICE TO LICENSEE:
 *
 * This source code and/or documentation ("Licensed Deliverables") are
 * subject to NVIDIA intellectual property rights under U.S. and
 * international Copyright laws.
 *
 * These Licensed Deliverables contained herein is PROPRIETARY and
 * CONFIDENTIAL to NVIDIA and is being provided under the terms and
 * conditions of a form of NVIDIA software license agreement by and
 * between NVIDIA and Licensee ("License Agreement") or electronically
 * accepted by Licensee.  Notwithstanding any terms or conditions to
 * the contrary in the License Agreement, reproduction or disclosure
 * of the Licensed Deliverables to any third party without the express
 * written consent of NVIDIA is prohibited.
 *
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, NVIDIA MAKES NO REPRESENTATION ABOUT THE
 * SUITABILITY OF THESE LICENSED DELIVERABLES FOR ANY PURPOSE.  IT IS
 * PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF ANY KIND.
 * NVIDIA DISCLAIMS ALL WARRANTIES WITH REGARD TO THESE LICENSED
 * DELIVERABLES, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NONINFRINGEMENT, AND FITNESS FOR A PARTICULAR PURPOSE.
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, IN NO EVENT SHALL NVIDIA BE LIABLE FOR ANY
 * SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, OR ANY
 * DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE
 * OF THESE LICENSED DELIVERABLES.
 *
 * U.S. Government End Users.  These Licensed Deliverables are a
 * "commercial item" as that term is defined at 48 C.F.R. 2.101 (OCT
 * 1995), consisting of "commercial computer software" and "commercial
 * computer software documentation" as such terms are used in 48
 * C.F.R. 12.212 (SEPT 1995) and is provided to the U.S. Government
 * only as a commercial end item.  Consistent with 48 C.F.R.12.212 and
 * 48 C.F.R. 227.7202-1 through 227.7202-4 (JUNE 1995), all
 * U.S. Government End Users acquire the Licensed Deliverables with
 * only those rights set forth herein.
 *
 * Any use of the Licensed Deliverables in individual and commercial
 * software must include, in the user documentation and internal
 * comments to the code, the above Disclaimer and U.S. Government End
 * Users Notice.
 */
 
/*
 * This is the public header file for the CUBLAS library, defining the API
 *
 * CUBLAS is an implementation of BLAS (Basic Linear Algebra Subroutines) 
 * on top of the CUDA runtime. 
 */

// #if !defined(CUBLAS_API_H_)
// #define CUBLAS_API_H_

// #ifndef CUBLASWINAPI
// #ifdef _WIN32
// #define CUBLASWINAPI __stdcall
// #else
// #define CUBLASWINAPI 
// #endif
// #endif

// #ifndef CUBLASAPI
// #error "This file should not be included without defining CUBLASAPI"
// #endif

// #include "driver_types.h"
// #include "cuComplex.h"   /* import complex data type */

// #if defined(__cplusplus)
// #endif /* __cplusplus */

/* CUBLAS status type returns */
/** enum cublasStatus_t */
public static final int
    CUBLAS_STATUS_SUCCESS         = 0,
    CUBLAS_STATUS_NOT_INITIALIZED = 1,
    CUBLAS_STATUS_ALLOC_FAILED    = 3,
    CUBLAS_STATUS_INVALID_VALUE   = 7,
    CUBLAS_STATUS_ARCH_MISMATCH   = 8,
    CUBLAS_STATUS_MAPPING_ERROR   = 11,
    CUBLAS_STATUS_EXECUTION_FAILED= 13,
    CUBLAS_STATUS_INTERNAL_ERROR  = 14,
    CUBLAS_STATUS_NOT_SUPPORTED   = 15,
    CUBLAS_STATUS_LICENSE_ERROR   = 16;


/** enum cublasFillMode_t */
public static final int
    CUBLAS_FILL_MODE_LOWER= 0, 
    CUBLAS_FILL_MODE_UPPER= 1;

/** enum cublasDiagType_t */
public static final int
    CUBLAS_DIAG_NON_UNIT= 0, 
    CUBLAS_DIAG_UNIT= 1; 

/** enum cublasSideMode_t */
public static final int
    CUBLAS_SIDE_LEFT = 0, 
    CUBLAS_SIDE_RIGHT= 1; 


/** enum cublasOperation_t */
public static final int
    CUBLAS_OP_N= 0,  
    CUBLAS_OP_T= 1,  
    CUBLAS_OP_C= 2;


/** enum cublasPointerMode_t */
public static final int 
    CUBLAS_POINTER_MODE_HOST   = 0,  
    CUBLAS_POINTER_MODE_DEVICE = 1;

/** enum cublasAtomicsMode_t */
public static final int 
    CUBLAS_ATOMICS_NOT_ALLOWED   = 0,  
    CUBLAS_ATOMICS_ALLOWED       = 1;

/* Opaque structure holding CUBLAS library context */
@Opaque public static class cublasContext extends Pointer {
    /** Empty constructor. */
    public cublasContext() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public cublasContext(Pointer p) { super(p); }
}

public static native @Cast("cublasStatus_t") int cublasCreate_v2(@ByPtrPtr cublasContext handle);
public static native @Cast("cublasStatus_t") int cublasDestroy_v2(cublasContext handle);
public static native @Cast("cublasStatus_t") int cublasGetVersion_v2(cublasContext handle, IntPointer version);
public static native @Cast("cublasStatus_t") int cublasGetVersion_v2(cublasContext handle, IntBuffer version);
public static native @Cast("cublasStatus_t") int cublasGetVersion_v2(cublasContext handle, int[] version);
public static native @Cast("cublasStatus_t") int cublasSetStream_v2(cublasContext handle, CUstream_st streamId); 
public static native @Cast("cublasStatus_t") int cublasGetStream_v2(cublasContext handle, @ByPtrPtr CUstream_st streamId); 

public static native @Cast("cublasStatus_t") int cublasGetPointerMode_v2(cublasContext handle, @Cast("cublasPointerMode_t*") IntPointer mode);
public static native @Cast("cublasStatus_t") int cublasGetPointerMode_v2(cublasContext handle, @Cast("cublasPointerMode_t*") IntBuffer mode);
public static native @Cast("cublasStatus_t") int cublasGetPointerMode_v2(cublasContext handle, @Cast("cublasPointerMode_t*") int[] mode);
public static native @Cast("cublasStatus_t") int cublasSetPointerMode_v2(cublasContext handle, @Cast("cublasPointerMode_t") int mode);         

public static native @Cast("cublasStatus_t") int cublasGetAtomicsMode(cublasContext handle, @Cast("cublasAtomicsMode_t*") IntPointer mode);
public static native @Cast("cublasStatus_t") int cublasGetAtomicsMode(cublasContext handle, @Cast("cublasAtomicsMode_t*") IntBuffer mode);
public static native @Cast("cublasStatus_t") int cublasGetAtomicsMode(cublasContext handle, @Cast("cublasAtomicsMode_t*") int[] mode);
public static native @Cast("cublasStatus_t") int cublasSetAtomicsMode(cublasContext handle, @Cast("cublasAtomicsMode_t") int mode);         

/* 
 * cublasStatus_t 
 * cublasSetVector (int n, int elemSize, const void *x, int incx, 
 *                  void *y, int incy) 
 *
 * copies n elements from a vector x in CPU memory space to a vector y 
 * in GPU memory space. Elements in both vectors are assumed to have a 
 * size of elemSize bytes. Storage spacing between consecutive elements
 * is incx for the source vector x and incy for the destination vector
 * y. In general, y points to an object, or part of an object, allocated
 * via cublasAlloc(). Column major format for two-dimensional matrices
 * is assumed throughout CUBLAS. Therefore, if the increment for a vector 
 * is equal to 1, this access a column vector while using an increment 
 * equal to the leading dimension of the respective matrix accesses a 
 * row vector.
 *
 * Return Values
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if incx, incy, or elemSize <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if an error occurred accessing GPU memory   
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasSetVector(int n, int elemSize, @Const Pointer x, 
                                             int incx, Pointer devicePtr, int incy);

/* 
 * cublasStatus_t 
 * cublasGetVector (int n, int elemSize, const void *x, int incx, 
 *                  void *y, int incy)
 * 
 * copies n elements from a vector x in GPU memory space to a vector y 
 * in CPU memory space. Elements in both vectors are assumed to have a 
 * size of elemSize bytes. Storage spacing between consecutive elements
 * is incx for the source vector x and incy for the destination vector
 * y. In general, x points to an object, or part of an object, allocated
 * via cublasAlloc(). Column major format for two-dimensional matrices
 * is assumed throughout CUBLAS. Therefore, if the increment for a vector 
 * is equal to 1, this access a column vector while using an increment 
 * equal to the leading dimension of the respective matrix accesses a 
 * row vector.
 *
 * Return Values
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if incx, incy, or elemSize <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if an error occurred accessing GPU memory   
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasGetVector(int n, int elemSize, @Const Pointer x, 
                                             int incx, Pointer y, int incy);

/*
 * cublasStatus_t 
 * cublasSetMatrix (int rows, int cols, int elemSize, const void *A, 
 *                  int lda, void *B, int ldb)
 *
 * copies a tile of rows x cols elements from a matrix A in CPU memory
 * space to a matrix B in GPU memory space. Each element requires storage
 * of elemSize bytes. Both matrices are assumed to be stored in column 
 * major format, with the leading dimension (i.e. number of rows) of 
 * source matrix A provided in lda, and the leading dimension of matrix B
 * provided in ldb. In general, B points to an object, or part of an 
 * object, that was allocated via cublasAlloc().
 *
 * Return Values 
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library has not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if rows or cols < 0, or elemSize, lda, or 
 *                                ldb <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if error occurred accessing GPU memory
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasSetMatrix(int rows, int cols, int elemSize, 
                                             @Const Pointer A, int lda, Pointer B, 
                                             int ldb);

/*
 * cublasStatus_t 
 * cublasGetMatrix (int rows, int cols, int elemSize, const void *A, 
 *                  int lda, void *B, int ldb)
 *
 * copies a tile of rows x cols elements from a matrix A in GPU memory
 * space to a matrix B in CPU memory space. Each element requires storage
 * of elemSize bytes. Both matrices are assumed to be stored in column 
 * major format, with the leading dimension (i.e. number of rows) of 
 * source matrix A provided in lda, and the leading dimension of matrix B
 * provided in ldb. In general, A points to an object, or part of an 
 * object, that was allocated via cublasAlloc().
 *
 * Return Values 
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library has not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if rows, cols, eleSize, lda, or ldb <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if error occurred accessing GPU memory
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasGetMatrix(int rows, int cols, int elemSize, 
                                             @Const Pointer A, int lda, Pointer B,
                                             int ldb);

/* 
 * cublasStatus 
 * cublasSetVectorAsync ( int n, int elemSize, const void *x, int incx, 
 *                       void *y, int incy, cudaStream_t stream );
 *
 * cublasSetVectorAsync has the same functionnality as cublasSetVector
 * but the transfer is done asynchronously within the CUDA stream passed
 * in parameter.
 *
 * Return Values
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if incx, incy, or elemSize <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if an error occurred accessing GPU memory   
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasSetVectorAsync(int n, int elemSize, 
                                                  @Const Pointer hostPtr, int incx, 
                                                  Pointer devicePtr, int incy,
                                                  CUstream_st stream);
/* 
 * cublasStatus 
 * cublasGetVectorAsync( int n, int elemSize, const void *x, int incx, 
 *                       void *y, int incy, cudaStream_t stream)
 * 
 * cublasGetVectorAsync has the same functionnality as cublasGetVector
 * but the transfer is done asynchronously within the CUDA stream passed
 * in parameter.
 *
 * Return Values
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if incx, incy, or elemSize <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if an error occurred accessing GPU memory   
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasGetVectorAsync(int n, int elemSize,
                                                  @Const Pointer devicePtr, int incx,
                                                  Pointer hostPtr, int incy,
                                                  CUstream_st stream);

/*
 * cublasStatus_t 
 * cublasSetMatrixAsync (int rows, int cols, int elemSize, const void *A, 
 *                       int lda, void *B, int ldb, cudaStream_t stream)
 *
 * cublasSetMatrixAsync has the same functionnality as cublasSetMatrix
 * but the transfer is done asynchronously within the CUDA stream passed
 * in parameter.
 *
 * Return Values 
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library has not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if rows or cols < 0, or elemSize, lda, or 
 *                                ldb <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if error occurred accessing GPU memory
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasSetMatrixAsync(int rows, int cols, int elemSize,
                                                  @Const Pointer A, int lda, Pointer B,
                                                  int ldb, CUstream_st stream);

/*
 * cublasStatus_t 
 * cublasGetMatrixAsync (int rows, int cols, int elemSize, const void *A, 
 *                       int lda, void *B, int ldb, cudaStream_t stream)
 *
 * cublasGetMatrixAsync has the same functionnality as cublasGetMatrix
 * but the transfer is done asynchronously within the CUDA stream passed
 * in parameter.
 *
 * Return Values 
 * -------------
 * CUBLAS_STATUS_NOT_INITIALIZED  if CUBLAS library has not been initialized
 * CUBLAS_STATUS_INVALID_VALUE    if rows, cols, eleSize, lda, or ldb <= 0
 * CUBLAS_STATUS_MAPPING_ERROR    if error occurred accessing GPU memory
 * CUBLAS_STATUS_SUCCESS          if the operation completed successfully
 */
public static native @Cast("cublasStatus_t") int cublasGetMatrixAsync(int rows, int cols, int elemSize,
                                                  @Const Pointer A, int lda, Pointer B,
                                                  int ldb, CUstream_st stream);


public static native void cublasXerbla(@Cast("const char*") BytePointer srName, int info);
public static native void cublasXerbla(String srName, int info);
/* ---------------- CUBLAS BLAS1 functions ---------------- */
public static native @Cast("cublasStatus_t") int cublasSnrm2_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const FloatPointer x, 
                                                     int incx, 
                                                     FloatPointer result);
public static native @Cast("cublasStatus_t") int cublasSnrm2_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const FloatBuffer x, 
                                                     int incx, 
                                                     FloatBuffer result);
public static native @Cast("cublasStatus_t") int cublasSnrm2_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const float[] x, 
                                                     int incx, 
                                                     float[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDnrm2_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const DoublePointer x, 
                                                     int incx, 
                                                     DoublePointer result);
public static native @Cast("cublasStatus_t") int cublasDnrm2_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const DoubleBuffer x, 
                                                     int incx, 
                                                     DoubleBuffer result);
public static native @Cast("cublasStatus_t") int cublasDnrm2_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const double[] x, 
                                                     int incx, 
                                                     double[] result);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasScnrm2_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      FloatPointer result);
public static native @Cast("cublasStatus_t") int cublasScnrm2_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      FloatBuffer result);
public static native @Cast("cublasStatus_t") int cublasScnrm2_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      float[] result);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDznrm2_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      DoublePointer result);
public static native @Cast("cublasStatus_t") int cublasDznrm2_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      DoubleBuffer result);
public static native @Cast("cublasStatus_t") int cublasDznrm2_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      double[] result);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasSdot_v2(cublasContext handle,
                                                     int n, 
                                                     @Const FloatPointer x, 
                                                     int incx, 
                                                     @Const FloatPointer y, 
                                                     int incy,
                                                     FloatPointer result);
public static native @Cast("cublasStatus_t") int cublasSdot_v2(cublasContext handle,
                                                     int n, 
                                                     @Const FloatBuffer x, 
                                                     int incx, 
                                                     @Const FloatBuffer y, 
                                                     int incy,
                                                     FloatBuffer result);
public static native @Cast("cublasStatus_t") int cublasSdot_v2(cublasContext handle,
                                                     int n, 
                                                     @Const float[] x, 
                                                     int incx, 
                                                     @Const float[] y, 
                                                     int incy,
                                                     float[] result);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDdot_v2(cublasContext handle,
                                                     int n, 
                                                     @Const DoublePointer x, 
                                                     int incx, 
                                                     @Const DoublePointer y,
                                                     int incy,
                                                     DoublePointer result);
public static native @Cast("cublasStatus_t") int cublasDdot_v2(cublasContext handle,
                                                     int n, 
                                                     @Const DoubleBuffer x, 
                                                     int incx, 
                                                     @Const DoubleBuffer y,
                                                     int incy,
                                                     DoubleBuffer result);
public static native @Cast("cublasStatus_t") int cublasDdot_v2(cublasContext handle,
                                                     int n, 
                                                     @Const double[] x, 
                                                     int incx, 
                                                     @Const double[] y,
                                                     int incy,
                                                     double[] result);  /* host or device pointer */
    
public static native @Cast("cublasStatus_t") int cublasCdotu_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      @Cast("const cuComplex*") float2 y, 
                                                      int incy,
                                                      @Cast("cuComplex*") float2 result);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasCdotc_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      @Cast("const cuComplex*") float2 y, 
                                                      int incy,
                                                      @Cast("cuComplex*") float2 result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasZdotu_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      @Cast("const cuDoubleComplex*") double2 y, 
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasZdotc_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 y, 
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasSscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const FloatPointer alpha,
                                                     FloatPointer x, 
                                                     int incx);
public static native @Cast("cublasStatus_t") int cublasSscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const FloatBuffer alpha,
                                                     FloatBuffer x, 
                                                     int incx);
public static native @Cast("cublasStatus_t") int cublasSscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const float[] alpha,
                                                     float[] x, 
                                                     int incx);
    
public static native @Cast("cublasStatus_t") int cublasDscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const DoublePointer alpha,
                                                     DoublePointer x, 
                                                     int incx);
public static native @Cast("cublasStatus_t") int cublasDscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const DoubleBuffer alpha,
                                                     DoubleBuffer x, 
                                                     int incx);
public static native @Cast("cublasStatus_t") int cublasDscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const double[] alpha,
                                                     double[] x, 
                                                     int incx);
    
public static native @Cast("cublasStatus_t") int cublasCscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("const cuComplex*") float2 alpha,
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx);

public static native @Cast("cublasStatus_t") int cublasCsscal_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const FloatPointer alpha,
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasCsscal_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const FloatBuffer alpha,
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasCsscal_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const float[] alpha,
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasZscal_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("const cuDoubleComplex*") double2 alpha,
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx);

public static native @Cast("cublasStatus_t") int cublasZdscal_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const DoublePointer alpha,
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasZdscal_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const DoubleBuffer alpha,
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasZdscal_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const double[] alpha,
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasSaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const FloatPointer alpha,
                                                      @Const FloatPointer x, 
                                                      int incx, 
                                                      FloatPointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const FloatBuffer alpha,
                                                      @Const FloatBuffer x, 
                                                      int incx, 
                                                      FloatBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const float[] alpha,
                                                      @Const float[] x, 
                                                      int incx, 
                                                      float[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasDaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const DoublePointer alpha,
                                                      @Const DoublePointer x, 
                                                      int incx, 
                                                      DoublePointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const DoubleBuffer alpha,
                                                      @Const DoubleBuffer x, 
                                                      int incx, 
                                                      DoubleBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const double[] alpha,
                                                      @Const double[] x, 
                                                      int incx, 
                                                      double[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasCaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 alpha,
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      @Cast("cuComplex*") float2 y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasZaxpy_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 alpha,
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      @Cast("cuDoubleComplex*") double2 y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasScopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const FloatPointer x, 
                                                      int incx, 
                                                      FloatPointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasScopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const FloatBuffer x, 
                                                      int incx, 
                                                      FloatBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasScopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const float[] x, 
                                                      int incx, 
                                                      float[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasDcopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const DoublePointer x, 
                                                      int incx, 
                                                      DoublePointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDcopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const DoubleBuffer x, 
                                                      int incx, 
                                                      DoubleBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDcopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Const double[] x, 
                                                      int incx, 
                                                      double[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasCcopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasZcopy_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);
    
public static native @Cast("cublasStatus_t") int cublasSswap_v2(cublasContext handle,
                                                      int n, 
                                                      FloatPointer x, 
                                                      int incx, 
                                                      FloatPointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSswap_v2(cublasContext handle,
                                                      int n, 
                                                      FloatBuffer x, 
                                                      int incx, 
                                                      FloatBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSswap_v2(cublasContext handle,
                                                      int n, 
                                                      float[] x, 
                                                      int incx, 
                                                      float[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasDswap_v2(cublasContext handle,
                                                      int n, 
                                                      DoublePointer x, 
                                                      int incx, 
                                                      DoublePointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDswap_v2(cublasContext handle,
                                                      int n, 
                                                      DoubleBuffer x, 
                                                      int incx, 
                                                      DoubleBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDswap_v2(cublasContext handle,
                                                      int n, 
                                                      double[] x, 
                                                      int incx, 
                                                      double[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasCswap_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasZswap_v2(cublasContext handle,
                                                      int n, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasIsamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const FloatPointer x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIsamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const FloatBuffer x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIsamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const float[] x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */
    
public static native @Cast("cublasStatus_t") int cublasIdamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const DoublePointer x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIdamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const DoubleBuffer x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIdamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const double[] x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasIcamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIcamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIcamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasIzamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIzamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIzamax_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasIsamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const FloatPointer x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIsamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const FloatBuffer x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIsamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const float[] x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasIdamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const DoublePointer x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIdamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const DoubleBuffer x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIdamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Const double[] x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasIcamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIcamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIcamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasIzamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      IntPointer result);
public static native @Cast("cublasStatus_t") int cublasIzamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      IntBuffer result);
public static native @Cast("cublasStatus_t") int cublasIzamin_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      int[] result); /* host or device pointer */
 
public static native @Cast("cublasStatus_t") int cublasSasum_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const FloatPointer x, 
                                                     int incx, 
                                                     FloatPointer result);
public static native @Cast("cublasStatus_t") int cublasSasum_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const FloatBuffer x, 
                                                     int incx, 
                                                     FloatBuffer result);
public static native @Cast("cublasStatus_t") int cublasSasum_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const float[] x, 
                                                     int incx, 
                                                     float[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDasum_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const DoublePointer x, 
                                                     int incx, 
                                                     DoublePointer result);
public static native @Cast("cublasStatus_t") int cublasDasum_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const DoubleBuffer x, 
                                                     int incx, 
                                                     DoubleBuffer result);
public static native @Cast("cublasStatus_t") int cublasDasum_v2(cublasContext handle, 
                                                     int n, 
                                                     @Const double[] x, 
                                                     int incx, 
                                                     double[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasScasum_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      FloatPointer result);
public static native @Cast("cublasStatus_t") int cublasScasum_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      FloatBuffer result);
public static native @Cast("cublasStatus_t") int cublasScasum_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx, 
                                                      float[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDzasum_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      DoublePointer result);
public static native @Cast("cublasStatus_t") int cublasDzasum_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      DoubleBuffer result);
public static native @Cast("cublasStatus_t") int cublasDzasum_v2(cublasContext handle, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx, 
                                                      double[] result); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasSrot_v2(cublasContext handle, 
                                                     int n, 
                                                     FloatPointer x, 
                                                     int incx, 
                                                     FloatPointer y, 
                                                     int incy, 
                                                     @Const FloatPointer c,
                                                     @Const FloatPointer s);
public static native @Cast("cublasStatus_t") int cublasSrot_v2(cublasContext handle, 
                                                     int n, 
                                                     FloatBuffer x, 
                                                     int incx, 
                                                     FloatBuffer y, 
                                                     int incy, 
                                                     @Const FloatBuffer c,
                                                     @Const FloatBuffer s);
public static native @Cast("cublasStatus_t") int cublasSrot_v2(cublasContext handle, 
                                                     int n, 
                                                     float[] x, 
                                                     int incx, 
                                                     float[] y, 
                                                     int incy, 
                                                     @Const float[] c,
                                                     @Const float[] s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDrot_v2(cublasContext handle, 
                                                     int n, 
                                                     DoublePointer x, 
                                                     int incx, 
                                                     DoublePointer y, 
                                                     int incy, 
                                                     @Const DoublePointer c,
                                                     @Const DoublePointer s);
public static native @Cast("cublasStatus_t") int cublasDrot_v2(cublasContext handle, 
                                                     int n, 
                                                     DoubleBuffer x, 
                                                     int incx, 
                                                     DoubleBuffer y, 
                                                     int incy, 
                                                     @Const DoubleBuffer c,
                                                     @Const DoubleBuffer s);
public static native @Cast("cublasStatus_t") int cublasDrot_v2(cublasContext handle, 
                                                     int n, 
                                                     double[] x, 
                                                     int incx, 
                                                     double[] y, 
                                                     int incy, 
                                                     @Const double[] c,
                                                     @Const double[] s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasCrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx, 
                                                     @Cast("cuComplex*") float2 y, 
                                                     int incy, 
                                                     @Const FloatPointer c,
                                                     @Cast("const cuComplex*") float2 s);
public static native @Cast("cublasStatus_t") int cublasCrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx, 
                                                     @Cast("cuComplex*") float2 y, 
                                                     int incy, 
                                                     @Const FloatBuffer c,
                                                     @Cast("const cuComplex*") float2 s);
public static native @Cast("cublasStatus_t") int cublasCrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx, 
                                                     @Cast("cuComplex*") float2 y, 
                                                     int incy, 
                                                     @Const float[] c,
                                                     @Cast("const cuComplex*") float2 s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasCsrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx, 
                                                     @Cast("cuComplex*") float2 y, 
                                                     int incy, 
                                                     @Const FloatPointer c,
                                                     @Const FloatPointer s);
public static native @Cast("cublasStatus_t") int cublasCsrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx, 
                                                     @Cast("cuComplex*") float2 y, 
                                                     int incy, 
                                                     @Const FloatBuffer c,
                                                     @Const FloatBuffer s);
public static native @Cast("cublasStatus_t") int cublasCsrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuComplex*") float2 x, 
                                                     int incx, 
                                                     @Cast("cuComplex*") float2 y, 
                                                     int incy, 
                                                     @Const float[] c,
                                                     @Const float[] s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasZrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx, 
                                                     @Cast("cuDoubleComplex*") double2 y, 
                                                     int incy, 
                                                     @Const DoublePointer c,
                                                     @Cast("const cuDoubleComplex*") double2 s);
public static native @Cast("cublasStatus_t") int cublasZrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx, 
                                                     @Cast("cuDoubleComplex*") double2 y, 
                                                     int incy, 
                                                     @Const DoubleBuffer c,
                                                     @Cast("const cuDoubleComplex*") double2 s);
public static native @Cast("cublasStatus_t") int cublasZrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx, 
                                                     @Cast("cuDoubleComplex*") double2 y, 
                                                     int incy, 
                                                     @Const double[] c,
                                                     @Cast("const cuDoubleComplex*") double2 s);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasZdrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx, 
                                                     @Cast("cuDoubleComplex*") double2 y, 
                                                     int incy, 
                                                     @Const DoublePointer c,
                                                     @Const DoublePointer s);
public static native @Cast("cublasStatus_t") int cublasZdrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx, 
                                                     @Cast("cuDoubleComplex*") double2 y, 
                                                     int incy, 
                                                     @Const DoubleBuffer c,
                                                     @Const DoubleBuffer s);
public static native @Cast("cublasStatus_t") int cublasZdrot_v2(cublasContext handle, 
                                                     int n, 
                                                     @Cast("cuDoubleComplex*") double2 x, 
                                                     int incx, 
                                                     @Cast("cuDoubleComplex*") double2 y, 
                                                     int incy, 
                                                     @Const double[] c,
                                                     @Const double[] s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasSrotg_v2(cublasContext handle, 
                                                     FloatPointer a,
                                                     FloatPointer b,
                                                     FloatPointer c,
                                                     FloatPointer s);
public static native @Cast("cublasStatus_t") int cublasSrotg_v2(cublasContext handle, 
                                                     FloatBuffer a,
                                                     FloatBuffer b,
                                                     FloatBuffer c,
                                                     FloatBuffer s);
public static native @Cast("cublasStatus_t") int cublasSrotg_v2(cublasContext handle, 
                                                     float[] a,
                                                     float[] b,
                                                     float[] c,
                                                     float[] s);  /* host or device pointer */
    
public static native @Cast("cublasStatus_t") int cublasDrotg_v2(cublasContext handle, 
                                                     DoublePointer a,
                                                     DoublePointer b,
                                                     DoublePointer c,
                                                     DoublePointer s);
public static native @Cast("cublasStatus_t") int cublasDrotg_v2(cublasContext handle, 
                                                     DoubleBuffer a,
                                                     DoubleBuffer b,
                                                     DoubleBuffer c,
                                                     DoubleBuffer s);
public static native @Cast("cublasStatus_t") int cublasDrotg_v2(cublasContext handle, 
                                                     double[] a,
                                                     double[] b,
                                                     double[] c,
                                                     double[] s); /* host or device pointer */
    
public static native @Cast("cublasStatus_t") int cublasCrotg_v2(cublasContext handle, 
                                                     @Cast("cuComplex*") float2 a,
                                                     @Cast("cuComplex*") float2 b,
                                                     FloatPointer c,
                                                     @Cast("cuComplex*") float2 s);
public static native @Cast("cublasStatus_t") int cublasCrotg_v2(cublasContext handle, 
                                                     @Cast("cuComplex*") float2 a,
                                                     @Cast("cuComplex*") float2 b,
                                                     FloatBuffer c,
                                                     @Cast("cuComplex*") float2 s);
public static native @Cast("cublasStatus_t") int cublasCrotg_v2(cublasContext handle, 
                                                     @Cast("cuComplex*") float2 a,
                                                     @Cast("cuComplex*") float2 b,
                                                     float[] c,
                                                     @Cast("cuComplex*") float2 s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasZrotg_v2(cublasContext handle, 
                                                     @Cast("cuDoubleComplex*") double2 a,
                                                     @Cast("cuDoubleComplex*") double2 b,
                                                     DoublePointer c,
                                                     @Cast("cuDoubleComplex*") double2 s);
public static native @Cast("cublasStatus_t") int cublasZrotg_v2(cublasContext handle, 
                                                     @Cast("cuDoubleComplex*") double2 a,
                                                     @Cast("cuDoubleComplex*") double2 b,
                                                     DoubleBuffer c,
                                                     @Cast("cuDoubleComplex*") double2 s);
public static native @Cast("cublasStatus_t") int cublasZrotg_v2(cublasContext handle, 
                                                     @Cast("cuDoubleComplex*") double2 a,
                                                     @Cast("cuDoubleComplex*") double2 b,
                                                     double[] c,
                                                     @Cast("cuDoubleComplex*") double2 s); /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasSrotm_v2(cublasContext handle, 
                                                     int n, 
                                                     FloatPointer x, 
                                                     int incx, 
                                                     FloatPointer y, 
                                                     int incy, 
                                                     @Const FloatPointer param);
public static native @Cast("cublasStatus_t") int cublasSrotm_v2(cublasContext handle, 
                                                     int n, 
                                                     FloatBuffer x, 
                                                     int incx, 
                                                     FloatBuffer y, 
                                                     int incy, 
                                                     @Const FloatBuffer param);
public static native @Cast("cublasStatus_t") int cublasSrotm_v2(cublasContext handle, 
                                                     int n, 
                                                     float[] x, 
                                                     int incx, 
                                                     float[] y, 
                                                     int incy, 
                                                     @Const float[] param);  /* host or device pointer */

public static native @Cast("cublasStatus_t") int cublasDrotm_v2(cublasContext handle, 
                                                     int n, 
                                                     DoublePointer x, 
                                                     int incx, 
                                                     DoublePointer y, 
                                                     int incy, 
                                                     @Const DoublePointer param);
public static native @Cast("cublasStatus_t") int cublasDrotm_v2(cublasContext handle, 
                                                     int n, 
                                                     DoubleBuffer x, 
                                                     int incx, 
                                                     DoubleBuffer y, 
                                                     int incy, 
                                                     @Const DoubleBuffer param);
public static native @Cast("cublasStatus_t") int cublasDrotm_v2(cublasContext handle, 
                                                     int n, 
                                                     double[] x, 
                                                     int incx, 
                                                     double[] y, 
                                                     int incy, 
                                                     @Const double[] param);  /* host or device pointer */
        
public static native @Cast("cublasStatus_t") int cublasSrotmg_v2(cublasContext handle, 
                                                      FloatPointer d1,
                                                      FloatPointer d2,
                                                      FloatPointer x1,
                                                      @Const FloatPointer y1,
                                                      FloatPointer param);
public static native @Cast("cublasStatus_t") int cublasSrotmg_v2(cublasContext handle, 
                                                      FloatBuffer d1,
                                                      FloatBuffer d2,
                                                      FloatBuffer x1,
                                                      @Const FloatBuffer y1,
                                                      FloatBuffer param);
public static native @Cast("cublasStatus_t") int cublasSrotmg_v2(cublasContext handle, 
                                                      float[] d1,
                                                      float[] d2,
                                                      float[] x1,
                                                      @Const float[] y1,
                                                      float[] param);    /* host or device pointer */
                                         
public static native @Cast("cublasStatus_t") int cublasDrotmg_v2(cublasContext handle, 
                                                      DoublePointer d1,  
                                                      DoublePointer d2,  
                                                      DoublePointer x1,  
                                                      @Const DoublePointer y1,  
                                                      DoublePointer param);
public static native @Cast("cublasStatus_t") int cublasDrotmg_v2(cublasContext handle, 
                                                      DoubleBuffer d1,  
                                                      DoubleBuffer d2,  
                                                      DoubleBuffer x1,  
                                                      @Const DoubleBuffer y1,  
                                                      DoubleBuffer param);
public static native @Cast("cublasStatus_t") int cublasDrotmg_v2(cublasContext handle, 
                                                      double[] d1,  
                                                      double[] d2,  
                                                      double[] x1,  
                                                      @Const double[] y1,  
                                                      double[] param);    /* host or device pointer */  

/* --------------- CUBLAS BLAS2 functions  ---------------- */

/* GEMV */
public static native @Cast("cublasStatus_t") int cublasSgemv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m, 
                                                      int n, 
                                                      @Const FloatPointer alpha,
                                                      @Const FloatPointer A, 
                                                      int lda, 
                                                      @Const FloatPointer x, 
                                                      int incx, 
                                                      @Const FloatPointer beta,
                                                      FloatPointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSgemv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m, 
                                                      int n, 
                                                      @Const FloatBuffer alpha,
                                                      @Const FloatBuffer A, 
                                                      int lda, 
                                                      @Const FloatBuffer x, 
                                                      int incx, 
                                                      @Const FloatBuffer beta,
                                                      FloatBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSgemv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m, 
                                                      int n, 
                                                      @Const float[] alpha,
                                                      @Const float[] A, 
                                                      int lda, 
                                                      @Const float[] x, 
                                                      int incx, 
                                                      @Const float[] beta,
                                                      float[] y, 
                                                      int incy);  
 
public static native @Cast("cublasStatus_t") int cublasDgemv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      @Const DoublePointer alpha, 
                                                      @Const DoublePointer A,
                                                      int lda,
                                                      @Const DoublePointer x,
                                                      int incx,
                                                      @Const DoublePointer beta,
                                                      DoublePointer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDgemv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      @Const DoubleBuffer alpha, 
                                                      @Const DoubleBuffer A,
                                                      int lda,
                                                      @Const DoubleBuffer x,
                                                      int incx,
                                                      @Const DoubleBuffer beta,
                                                      DoubleBuffer y, 
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDgemv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      @Const double[] alpha, 
                                                      @Const double[] A,
                                                      int lda,
                                                      @Const double[] x,
                                                      int incx,
                                                      @Const double[] beta,
                                                      double[] y, 
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasCgemv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha, 
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 beta, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasZgemv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda, 
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 beta,  
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);
/* GBMV */                                
public static native @Cast("cublasStatus_t") int cublasSgbmv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer A, 
                                                      int lda, 
                                                      @Const FloatPointer x,
                                                      int incx,
                                                      @Const FloatPointer beta,  
                                                      FloatPointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSgbmv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer A, 
                                                      int lda, 
                                                      @Const FloatBuffer x,
                                                      int incx,
                                                      @Const FloatBuffer beta,  
                                                      FloatBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSgbmv_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Const float[] alpha,  
                                                      @Const float[] A, 
                                                      int lda, 
                                                      @Const float[] x,
                                                      int incx,
                                                      @Const float[] beta,  
                                                      float[] y,
                                                      int incy);                                
                                
public static native @Cast("cublasStatus_t") int cublasDgbmv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Const DoublePointer alpha, 
                                                      @Const DoublePointer A,
                                                      int lda, 
                                                      @Const DoublePointer x,
                                                      int incx,
                                                      @Const DoublePointer beta, 
                                                      DoublePointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDgbmv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Const DoubleBuffer alpha, 
                                                      @Const DoubleBuffer A,
                                                      int lda, 
                                                      @Const DoubleBuffer x,
                                                      int incx,
                                                      @Const DoubleBuffer beta, 
                                                      DoubleBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDgbmv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Const double[] alpha, 
                                                      @Const double[] A,
                                                      int lda, 
                                                      @Const double[] x,
                                                      int incx,
                                                      @Const double[] beta, 
                                                      double[] y,
                                                      int incy);
                                         
public static native @Cast("cublasStatus_t") int cublasCgbmv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Cast("const cuComplex*") float2 alpha, 
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda, 
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 beta, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);                                             
                                         
public static native @Cast("cublasStatus_t") int cublasZgbmv_v2(cublasContext handle,
                                                      @Cast("cublasOperation_t") int trans, 
                                                      int m,
                                                      int n,
                                                      int kl,
                                                      int ku, 
                                                      @Cast("const cuDoubleComplex*") double2 alpha, 
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda, 
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 beta, 
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);   
                                         
/* TRMV */
public static native @Cast("cublasStatus_t") int cublasStrmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatPointer A, 
                                                      int lda, 
                                                      FloatPointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStrmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatBuffer A, 
                                                      int lda, 
                                                      FloatBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStrmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const float[] A, 
                                                      int lda, 
                                                      float[] x, 
                                                      int incx);                                                 

public static native @Cast("cublasStatus_t") int cublasDtrmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoublePointer A, 
                                                      int lda, 
                                                      DoublePointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtrmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoubleBuffer A, 
                                                      int lda, 
                                                      DoubleBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtrmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const double[] A, 
                                                      int lda, 
                                                      double[] x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasCtrmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 A, 
                                                      int lda, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);
                                        
public static native @Cast("cublasStatus_t") int cublasZtrmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 A, 
                                                      int lda, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);
                                                                                                             
/* TBMV */
public static native @Cast("cublasStatus_t") int cublasStbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const FloatPointer A, 
                                                      int lda, 
                                                      FloatPointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const FloatBuffer A, 
                                                      int lda, 
                                                      FloatBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const float[] A, 
                                                      int lda, 
                                                      float[] x, 
                                                      int incx);                                                 

public static native @Cast("cublasStatus_t") int cublasDtbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const DoublePointer A, 
                                                      int lda, 
                                                      DoublePointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const DoubleBuffer A, 
                                                      int lda, 
                                                      DoubleBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const double[] A, 
                                                      int lda, 
                                                      double[] x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasCtbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Cast("const cuComplex*") float2 A, 
                                                      int lda, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);
                                               
public static native @Cast("cublasStatus_t") int cublasZtbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Cast("const cuDoubleComplex*") double2 A, 
                                                      int lda, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);
                                         
/* TPMV */
public static native @Cast("cublasStatus_t") int cublasStpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatPointer AP, 
                                                      FloatPointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatBuffer AP, 
                                                      FloatBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const float[] AP, 
                                                      float[] x, 
                                                      int incx);                                                 

public static native @Cast("cublasStatus_t") int cublasDtpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoublePointer AP, 
                                                      DoublePointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoubleBuffer AP, 
                                                      DoubleBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const double[] AP, 
                                                      double[] x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasCtpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 AP, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);
                                                
public static native @Cast("cublasStatus_t") int cublasZtpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 AP, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);

/* TRSV */
public static native @Cast("cublasStatus_t") int cublasStrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatPointer A, 
                                                      int lda, 
                                                      FloatPointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatBuffer A, 
                                                      int lda, 
                                                      FloatBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const float[] A, 
                                                      int lda, 
                                                      float[] x, 
                                                      int incx);                                                 

public static native @Cast("cublasStatus_t") int cublasDtrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoublePointer A, 
                                                      int lda, 
                                                      DoublePointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoubleBuffer A, 
                                                      int lda, 
                                                      DoubleBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const double[] A, 
                                                      int lda, 
                                                      double[] x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasCtrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 A, 
                                                      int lda, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasZtrsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 A, 
                                                      int lda, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);

/* TPSV */
public static native @Cast("cublasStatus_t") int cublasStpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatPointer AP, 
                                                      FloatPointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const FloatBuffer AP, 
                                                      FloatBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const float[] AP, 
                                                      float[] x, 
                                                      int incx);  
                                                                                                            
public static native @Cast("cublasStatus_t") int cublasDtpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoublePointer AP, 
                                                      DoublePointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const DoubleBuffer AP, 
                                                      DoubleBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Const double[] AP, 
                                                      double[] x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasCtpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuComplex*") float2 AP, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasZtpsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 AP, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);
/* TBSV */                                         
public static native @Cast("cublasStatus_t") int cublasStbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const FloatPointer A, 
                                                      int lda, 
                                                      FloatPointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const FloatBuffer A, 
                                                      int lda, 
                                                      FloatBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasStbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const float[] A, 
                                                      int lda, 
                                                      float[] x, 
                                                      int incx);

public static native @Cast("cublasStatus_t") int cublasDtbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const DoublePointer A, 
                                                      int lda, 
                                                      DoublePointer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const DoubleBuffer A, 
                                                      int lda, 
                                                      DoubleBuffer x, 
                                                      int incx);
public static native @Cast("cublasStatus_t") int cublasDtbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Const double[] A, 
                                                      int lda, 
                                                      double[] x, 
                                                      int incx);
                                         
public static native @Cast("cublasStatus_t") int cublasCtbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Cast("const cuComplex*") float2 A, 
                                                      int lda, 
                                                      @Cast("cuComplex*") float2 x, 
                                                      int incx);
                                         
public static native @Cast("cublasStatus_t") int cublasZtbsv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      @Cast("cublasOperation_t") int trans, 
                                                      @Cast("cublasDiagType_t") int diag, 
                                                      int n, 
                                                      int k, 
                                                      @Cast("const cuDoubleComplex*") double2 A, 
                                                      int lda, 
                                                      @Cast("cuDoubleComplex*") double2 x, 
                                                      int incx);     
                                         
/* SYMV/HEMV */
public static native @Cast("cublasStatus_t") int cublasSsymv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Const FloatPointer alpha, 
                                                      @Const FloatPointer A,
                                                      int lda,
                                                      @Const FloatPointer x,
                                                      int incx,
                                                      @Const FloatPointer beta, 
                                                      FloatPointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSsymv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Const FloatBuffer alpha, 
                                                      @Const FloatBuffer A,
                                                      int lda,
                                                      @Const FloatBuffer x,
                                                      int incx,
                                                      @Const FloatBuffer beta, 
                                                      FloatBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSsymv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Const float[] alpha, 
                                                      @Const float[] A,
                                                      int lda,
                                                      @Const float[] x,
                                                      int incx,
                                                      @Const float[] beta, 
                                                      float[] y,
                                                      int incy);

public static native @Cast("cublasStatus_t") int cublasDsymv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Const DoublePointer alpha, 
                                                      @Const DoublePointer A,
                                                      int lda,
                                                      @Const DoublePointer x,
                                                      int incx,
                                                      @Const DoublePointer beta, 
                                                      DoublePointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDsymv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Const DoubleBuffer alpha, 
                                                      @Const DoubleBuffer A,
                                                      int lda,
                                                      @Const DoubleBuffer x,
                                                      int incx,
                                                      @Const DoubleBuffer beta, 
                                                      DoubleBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDsymv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Const double[] alpha, 
                                                      @Const double[] A,
                                                      int lda,
                                                      @Const double[] x,
                                                      int incx,
                                                      @Const double[] beta, 
                                                      double[] y,
                                                      int incy);
    
public static native @Cast("cublasStatus_t") int cublasCsymv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha, 
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 beta, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);                                     
                                     
public static native @Cast("cublasStatus_t") int cublasZsymv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha, 
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 beta, 
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);                                            
                                     
public static native @Cast("cublasStatus_t") int cublasChemv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha, 
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 beta, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);                                     
                                     
public static native @Cast("cublasStatus_t") int cublasZhemv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha, 
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 beta, 
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);   
                                     
/* SBMV/HBMV */
public static native @Cast("cublasStatus_t") int cublasSsbmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Const FloatPointer alpha, 
                                                      @Const FloatPointer A,
                                                      int lda,
                                                      @Const FloatPointer x, 
                                                      int incx,
                                                      @Const FloatPointer beta, 
                                                      FloatPointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSsbmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Const FloatBuffer alpha, 
                                                      @Const FloatBuffer A,
                                                      int lda,
                                                      @Const FloatBuffer x, 
                                                      int incx,
                                                      @Const FloatBuffer beta, 
                                                      FloatBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSsbmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Const float[] alpha, 
                                                      @Const float[] A,
                                                      int lda,
                                                      @Const float[] x, 
                                                      int incx,
                                                      @Const float[] beta, 
                                                      float[] y,
                                                      int incy);
                                      
public static native @Cast("cublasStatus_t") int cublasDsbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Const DoublePointer alpha, 
                                                      @Const DoublePointer A,
                                                      int lda,
                                                      @Const DoublePointer x, 
                                                      int incx,
                                                      @Const DoublePointer beta, 
                                                      DoublePointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDsbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Const DoubleBuffer alpha, 
                                                      @Const DoubleBuffer A,
                                                      int lda,
                                                      @Const DoubleBuffer x, 
                                                      int incx,
                                                      @Const DoubleBuffer beta, 
                                                      DoubleBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDsbmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Const double[] alpha, 
                                                      @Const double[] A,
                                                      int lda,
                                                      @Const double[] x, 
                                                      int incx,
                                                      @Const double[] beta, 
                                                      double[] y,
                                                      int incy);
                                      
public static native @Cast("cublasStatus_t") int cublasChbmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Cast("const cuComplex*") float2 alpha, 
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 x, 
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 beta, 
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);
                                      
public static native @Cast("cublasStatus_t") int cublasZhbmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, 
                                                      int n,
                                                      int k,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 x, 
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 beta, 
                                                      @Cast("cuDoubleComplex*") double2 y,
                                                      int incy);                                                                            
                                                                                                                                                   
/* SPMV/HPMV */
public static native @Cast("cublasStatus_t") int cublasSspmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const FloatPointer alpha,                                           
                                                      @Const FloatPointer AP,
                                                      @Const FloatPointer x,
                                                      int incx,
                                                      @Const FloatPointer beta,  
                                                      FloatPointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSspmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const FloatBuffer alpha,                                           
                                                      @Const FloatBuffer AP,
                                                      @Const FloatBuffer x,
                                                      int incx,
                                                      @Const FloatBuffer beta,  
                                                      FloatBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasSspmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const float[] alpha,                                           
                                                      @Const float[] AP,
                                                      @Const float[] x,
                                                      int incx,
                                                      @Const float[] beta,  
                                                      float[] y,
                                                      int incy);
    
public static native @Cast("cublasStatus_t") int cublasDspmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer AP,
                                                      @Const DoublePointer x,
                                                      int incx,
                                                      @Const DoublePointer beta,  
                                                      DoublePointer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDspmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer AP,
                                                      @Const DoubleBuffer x,
                                                      int incx,
                                                      @Const DoubleBuffer beta,  
                                                      DoubleBuffer y,
                                                      int incy);
public static native @Cast("cublasStatus_t") int cublasDspmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const double[] alpha,  
                                                      @Const double[] AP,
                                                      @Const double[] x,
                                                      int incx,
                                                      @Const double[] beta,  
                                                      double[] y,
                                                      int incy);                                     
                                     
public static native @Cast("cublasStatus_t") int cublasChpmv_v2(cublasContext handle, 
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 AP,
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 beta,  
                                                      @Cast("cuComplex*") float2 y,
                                                      int incy);
                                     
public static native @Cast("cublasStatus_t") int cublasZhpmv_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 AP,
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 beta,  
                                                      @Cast("cuDoubleComplex*") double2 y, 
                                                      int incy);

/* GER */
public static native @Cast("cublasStatus_t") int cublasSger_v2(cublasContext handle,
                                                     int m,
                                                     int n,
                                                     @Const FloatPointer alpha,  
                                                     @Const FloatPointer x,
                                                     int incx,
                                                     @Const FloatPointer y,
                                                     int incy,
                                                     FloatPointer A,
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasSger_v2(cublasContext handle,
                                                     int m,
                                                     int n,
                                                     @Const FloatBuffer alpha,  
                                                     @Const FloatBuffer x,
                                                     int incx,
                                                     @Const FloatBuffer y,
                                                     int incy,
                                                     FloatBuffer A,
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasSger_v2(cublasContext handle,
                                                     int m,
                                                     int n,
                                                     @Const float[] alpha,  
                                                     @Const float[] x,
                                                     int incx,
                                                     @Const float[] y,
                                                     int incy,
                                                     float[] A,
                                                     int lda);
                                    
public static native @Cast("cublasStatus_t") int cublasDger_v2(cublasContext handle, 
                                                     int m,
                                                     int n,
                                                     @Const DoublePointer alpha,   
                                                     @Const DoublePointer x,
                                                     int incx,
                                                     @Const DoublePointer y,
                                                     int incy,
                                                     DoublePointer A,
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasDger_v2(cublasContext handle, 
                                                     int m,
                                                     int n,
                                                     @Const DoubleBuffer alpha,   
                                                     @Const DoubleBuffer x,
                                                     int incx,
                                                     @Const DoubleBuffer y,
                                                     int incy,
                                                     DoubleBuffer A,
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasDger_v2(cublasContext handle, 
                                                     int m,
                                                     int n,
                                                     @Const double[] alpha,   
                                                     @Const double[] x,
                                                     int incx,
                                                     @Const double[] y,
                                                     int incy,
                                                     double[] A,
                                                     int lda);
                                    
public static native @Cast("cublasStatus_t") int cublasCgeru_v2(cublasContext handle, 
                                                      int m,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 y,
                                                      int incy,
                                                      @Cast("cuComplex*") float2 A,
                                                      int lda);

public static native @Cast("cublasStatus_t") int cublasCgerc_v2(cublasContext handle,
                                                      int m,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 y,
                                                      int incy,
                                                      @Cast("cuComplex*") float2 A,
                                                      int lda);                                   

public static native @Cast("cublasStatus_t") int cublasZgeru_v2(cublasContext handle, 
                                                      int m,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 y,
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 A,
                                                      int lda);

public static native @Cast("cublasStatus_t") int cublasZgerc_v2(cublasContext handle,
                                                      int m,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 y,
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 A,
                                                      int lda); 
                                    
/* SYR/HER */
public static native @Cast("cublasStatus_t") int cublasSsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatPointer alpha,  
                                                     @Const FloatPointer x,
                                                     int incx,
                                                     FloatPointer A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasSsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatBuffer alpha,  
                                                     @Const FloatBuffer x,
                                                     int incx,
                                                     FloatBuffer A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasSsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const float[] alpha,  
                                                     @Const float[] x,
                                                     int incx,
                                                     float[] A, 
                                                     int lda);
                                    
public static native @Cast("cublasStatus_t") int cublasDsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoublePointer alpha,  
                                                     @Const DoublePointer x,
                                                     int incx,
                                                     DoublePointer A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasDsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoubleBuffer alpha,  
                                                     @Const DoubleBuffer x,
                                                     int incx,
                                                     DoubleBuffer A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasDsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const double[] alpha,  
                                                     @Const double[] x,
                                                     int incx,
                                                     double[] A, 
                                                     int lda);  
                                        
public static native @Cast("cublasStatus_t") int cublasCsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Cast("const cuComplex*") float2 alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 A, 
                                                     int lda);
                                    
public static native @Cast("cublasStatus_t") int cublasZsyr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Cast("const cuDoubleComplex*") double2 alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 A, 
                                                     int lda);                                          
                                                                      
public static native @Cast("cublasStatus_t") int cublasCher_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatPointer alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasCher_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatBuffer alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasCher_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const float[] alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 A, 
                                                     int lda); 
                                    
public static native @Cast("cublasStatus_t") int cublasZher_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoublePointer alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasZher_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoubleBuffer alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 A, 
                                                     int lda);
public static native @Cast("cublasStatus_t") int cublasZher_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const double[] alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 A, 
                                                     int lda); 

/* SPR/HPR */                                    
public static native @Cast("cublasStatus_t") int cublasSspr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatPointer alpha,  
                                                     @Const FloatPointer x,
                                                     int incx,
                                                     FloatPointer AP);
public static native @Cast("cublasStatus_t") int cublasSspr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatBuffer alpha,  
                                                     @Const FloatBuffer x,
                                                     int incx,
                                                     FloatBuffer AP);
public static native @Cast("cublasStatus_t") int cublasSspr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const float[] alpha,  
                                                     @Const float[] x,
                                                     int incx,
                                                     float[] AP);
                                    
public static native @Cast("cublasStatus_t") int cublasDspr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoublePointer alpha,  
                                                     @Const DoublePointer x,
                                                     int incx,
                                                     DoublePointer AP);
public static native @Cast("cublasStatus_t") int cublasDspr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoubleBuffer alpha,  
                                                     @Const DoubleBuffer x,
                                                     int incx,
                                                     DoubleBuffer AP);
public static native @Cast("cublasStatus_t") int cublasDspr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const double[] alpha,  
                                                     @Const double[] x,
                                                     int incx,
                                                     double[] AP);

public static native @Cast("cublasStatus_t") int cublasChpr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatPointer alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 AP);
public static native @Cast("cublasStatus_t") int cublasChpr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const FloatBuffer alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 AP);
public static native @Cast("cublasStatus_t") int cublasChpr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const float[] alpha,  
                                                     @Cast("const cuComplex*") float2 x,
                                                     int incx,
                                                     @Cast("cuComplex*") float2 AP);

public static native @Cast("cublasStatus_t") int cublasZhpr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoublePointer alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 AP);
public static native @Cast("cublasStatus_t") int cublasZhpr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const DoubleBuffer alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 AP);
public static native @Cast("cublasStatus_t") int cublasZhpr_v2(cublasContext handle,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     int n,
                                                     @Const double[] alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 x,
                                                     int incx,
                                                     @Cast("cuDoubleComplex*") double2 AP);                       
    
/* SYR2/HER2 */                                    
public static native @Cast("cublasStatus_t") int cublasSsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer x,
                                                      int incx,
                                                      @Const FloatPointer y,
                                                      int incy,
                                                      FloatPointer A,
                                                      int lda);
public static native @Cast("cublasStatus_t") int cublasSsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer x,
                                                      int incx,
                                                      @Const FloatBuffer y,
                                                      int incy,
                                                      FloatBuffer A,
                                                      int lda);
public static native @Cast("cublasStatus_t") int cublasSsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const float[] alpha,  
                                                      @Const float[] x,
                                                      int incx,
                                                      @Const float[] y,
                                                      int incy,
                                                      float[] A,
                                                      int lda);
    
public static native @Cast("cublasStatus_t") int cublasDsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer x,
                                                      int incx,
                                                      @Const DoublePointer y,
                                                      int incy,
                                                      DoublePointer A,
                                                      int lda);
public static native @Cast("cublasStatus_t") int cublasDsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer x,
                                                      int incx,
                                                      @Const DoubleBuffer y,
                                                      int incy,
                                                      DoubleBuffer A,
                                                      int lda);
public static native @Cast("cublasStatus_t") int cublasDsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Const double[] alpha,  
                                                      @Const double[] x,
                                                      int incx,
                                                      @Const double[] y,
                                                      int incy,
                                                      double[] A,
                                                      int lda);
                                         
public static native @Cast("cublasStatus_t") int cublasCsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, int n, 
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx, 
                                                      @Cast("const cuComplex*") float2 y,
                                                      int incy, 
                                                      @Cast("cuComplex*") float2 A, 
                                                      int lda);   
    
public static native @Cast("cublasStatus_t") int cublasZsyr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 y,
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 A,
                                                      int lda);                       
    

public static native @Cast("cublasStatus_t") int cublasCher2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo, int n, 
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx, 
                                                      @Cast("const cuComplex*") float2 y,
                                                      int incy, 
                                                      @Cast("cuComplex*") float2 A, 
                                                      int lda);   

public static native @Cast("cublasStatus_t") int cublasZher2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n, 
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 y,
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 A,
                                                      int lda);                       

/* SPR2/HPR2 */
public static native @Cast("cublasStatus_t") int cublasSspr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer x,
                                                      int incx,
                                                      @Const FloatPointer y,
                                                      int incy,
                                                      FloatPointer AP);
public static native @Cast("cublasStatus_t") int cublasSspr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer x,
                                                      int incx,
                                                      @Const FloatBuffer y,
                                                      int incy,
                                                      FloatBuffer AP);
public static native @Cast("cublasStatus_t") int cublasSspr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const float[] alpha,  
                                                      @Const float[] x,
                                                      int incx,
                                                      @Const float[] y,
                                                      int incy,
                                                      float[] AP);
                                                                          
public static native @Cast("cublasStatus_t") int cublasDspr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer x,
                                                      int incx, 
                                                      @Const DoublePointer y,
                                                      int incy,
                                                      DoublePointer AP);
public static native @Cast("cublasStatus_t") int cublasDspr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer x,
                                                      int incx, 
                                                      @Const DoubleBuffer y,
                                                      int incy,
                                                      DoubleBuffer AP);
public static native @Cast("cublasStatus_t") int cublasDspr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Const double[] alpha,  
                                                      @Const double[] x,
                                                      int incx, 
                                                      @Const double[] y,
                                                      int incy,
                                                      double[] AP);
    

public static native @Cast("cublasStatus_t") int cublasChpr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 x,
                                                      int incx,
                                                      @Cast("const cuComplex*") float2 y,
                                                      int incy,
                                                      @Cast("cuComplex*") float2 AP);
                                     
public static native @Cast("cublasStatus_t") int cublasZhpr2_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 x,
                                                      int incx,
                                                      @Cast("const cuDoubleComplex*") double2 y,
                                                      int incy,
                                                      @Cast("cuDoubleComplex*") double2 AP); 

/* ---------------- CUBLAS BLAS3 functions ---------------- */

/* GEMM */
public static native @Cast("cublasStatus_t") int cublasSgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer A, 
                                                      int lda,
                                                      @Const FloatPointer B,
                                                      int ldb, 
                                                      @Const FloatPointer beta,  
                                                      FloatPointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasSgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer A, 
                                                      int lda,
                                                      @Const FloatBuffer B,
                                                      int ldb, 
                                                      @Const FloatBuffer beta,  
                                                      FloatBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasSgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Const float[] alpha,  
                                                      @Const float[] A, 
                                                      int lda,
                                                      @Const float[] B,
                                                      int ldb, 
                                                      @Const float[] beta,  
                                                      float[] C,
                                                      int ldc);
    
public static native @Cast("cublasStatus_t") int cublasDgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer A, 
                                                      int lda,
                                                      @Const DoublePointer B,
                                                      int ldb, 
                                                      @Const DoublePointer beta,  
                                                      DoublePointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer A, 
                                                      int lda,
                                                      @Const DoubleBuffer B,
                                                      int ldb, 
                                                      @Const DoubleBuffer beta,  
                                                      DoubleBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Const double[] alpha,  
                                                      @Const double[] A, 
                                                      int lda,
                                                      @Const double[] B,
                                                      int ldb, 
                                                      @Const double[] beta,  
                                                      double[] C,
                                                      int ldc);
                                        
public static native @Cast("cublasStatus_t") int cublasCgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 A, 
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 B,
                                                      int ldb, 
                                                      @Cast("const cuComplex*") float2 beta,  
                                                      @Cast("cuComplex*") float2 C,
                                                      int ldc);
                                        
public static native @Cast("cublasStatus_t") int cublasZgemm_v2(cublasContext handle, 
                                                      @Cast("cublasOperation_t") int transa,
                                                      @Cast("cublasOperation_t") int transb, 
                                                      int m,
                                                      int n,
                                                      int k,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A, 
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 B,
                                                      int ldb, 
                                                      @Cast("const cuDoubleComplex*") double2 beta,  
                                                      @Cast("cuDoubleComplex*") double2 C,
                                                      int ldc);                                                                                
                            
/* SYRK */
public static native @Cast("cublasStatus_t") int cublasSsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer A,
                                                      int lda,
                                                      @Const FloatPointer beta,  
                                                      FloatPointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasSsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer A,
                                                      int lda,
                                                      @Const FloatBuffer beta,  
                                                      FloatBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasSsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const float[] alpha,  
                                                      @Const float[] A,
                                                      int lda,
                                                      @Const float[] beta,  
                                                      float[] C,
                                                      int ldc);
                                     
public static native @Cast("cublasStatus_t") int cublasDsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer A,
                                                      int lda,
                                                      @Const DoublePointer beta,  
                                                      DoublePointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer A,
                                                      int lda,
                                                      @Const DoubleBuffer beta,  
                                                      DoubleBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const double[] alpha,  
                                                      @Const double[] A,
                                                      int lda,
                                                      @Const double[] beta,  
                                                      double[] C,
                                                      int ldc);   
                                     
public static native @Cast("cublasStatus_t") int cublasCsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 beta,  
                                                      @Cast("cuComplex*") float2 C,
                                                      int ldc);         
                                     
public static native @Cast("cublasStatus_t") int cublasZsyrk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 beta,  
                                                      @Cast("cuDoubleComplex*") double2 C, 
                                                      int ldc);
/* HERK */
public static native @Cast("cublasStatus_t") int cublasCherk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const FloatPointer alpha,  
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Const FloatPointer beta,  
                                                      @Cast("cuComplex*") float2 C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasCherk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const FloatBuffer alpha,  
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Const FloatBuffer beta,  
                                                      @Cast("cuComplex*") float2 C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasCherk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const float[] alpha,  
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Const float[] beta,  
                                                      @Cast("cuComplex*") float2 C,
                                                      int ldc);
    
public static native @Cast("cublasStatus_t") int cublasZherk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const DoublePointer alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Const DoublePointer beta,  
                                                      @Cast("cuDoubleComplex*") double2 C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasZherk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const DoubleBuffer alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Const DoubleBuffer beta,  
                                                      @Cast("cuDoubleComplex*") double2 C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasZherk_v2(cublasContext handle,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      int n,
                                                      int k,
                                                      @Const double[] alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Const double[] beta,  
                                                      @Cast("cuDoubleComplex*") double2 C,
                                                      int ldc);    

/* SYR2K */                                     
public static native @Cast("cublasStatus_t") int cublasSsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Const FloatPointer alpha,  
                                                       @Const FloatPointer A,
                                                       int lda,
                                                       @Const FloatPointer B,
                                                       int ldb,
                                                       @Const FloatPointer beta,  
                                                       FloatPointer C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasSsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Const FloatBuffer alpha,  
                                                       @Const FloatBuffer A,
                                                       int lda,
                                                       @Const FloatBuffer B,
                                                       int ldb,
                                                       @Const FloatBuffer beta,  
                                                       FloatBuffer C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasSsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Const float[] alpha,  
                                                       @Const float[] A,
                                                       int lda,
                                                       @Const float[] B,
                                                       int ldb,
                                                       @Const float[] beta,  
                                                       float[] C,
                                                       int ldc);  
                                      
public static native @Cast("cublasStatus_t") int cublasDsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Const DoublePointer alpha,  
                                                       @Const DoublePointer A,
                                                       int lda,
                                                       @Const DoublePointer B,
                                                       int ldb,
                                                       @Const DoublePointer beta,  
                                                       DoublePointer C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasDsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Const DoubleBuffer alpha,  
                                                       @Const DoubleBuffer A,
                                                       int lda,
                                                       @Const DoubleBuffer B,
                                                       int ldb,
                                                       @Const DoubleBuffer beta,  
                                                       DoubleBuffer C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasDsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Const double[] alpha,  
                                                       @Const double[] A,
                                                       int lda,
                                                       @Const double[] B,
                                                       int ldb,
                                                       @Const double[] beta,  
                                                       double[] C,
                                                       int ldc);
                                      
public static native @Cast("cublasStatus_t") int cublasCsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Cast("const cuComplex*") float2 alpha,  
                                                       @Cast("const cuComplex*") float2 A,
                                                       int lda,
                                                       @Cast("const cuComplex*") float2 B,
                                                       int ldb,
                                                       @Cast("const cuComplex*") float2 beta,  
                                                       @Cast("cuComplex*") float2 C,
                                                       int ldc);
                                      
public static native @Cast("cublasStatus_t") int cublasZsyr2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Cast("const cuDoubleComplex*") double2 alpha,  
                                                       @Cast("const cuDoubleComplex*") double2 A,
                                                       int lda,
                                                       @Cast("const cuDoubleComplex*") double2 B,
                                                       int ldb,
                                                       @Cast("const cuDoubleComplex*") double2 beta,  
                                                       @Cast("cuDoubleComplex*") double2 C,
                                                       int ldc);  
/* HER2K */                                       
public static native @Cast("cublasStatus_t") int cublasCher2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Cast("const cuComplex*") float2 alpha,  
                                                       @Cast("const cuComplex*") float2 A,
                                                       int lda,
                                                       @Cast("const cuComplex*") float2 B,
                                                       int ldb,
                                                       @Const FloatPointer beta,  
                                                       @Cast("cuComplex*") float2 C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasCher2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Cast("const cuComplex*") float2 alpha,  
                                                       @Cast("const cuComplex*") float2 A,
                                                       int lda,
                                                       @Cast("const cuComplex*") float2 B,
                                                       int ldb,
                                                       @Const FloatBuffer beta,  
                                                       @Cast("cuComplex*") float2 C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasCher2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans,
                                                       int n,
                                                       int k,
                                                       @Cast("const cuComplex*") float2 alpha,  
                                                       @Cast("const cuComplex*") float2 A,
                                                       int lda,
                                                       @Cast("const cuComplex*") float2 B,
                                                       int ldb,
                                                       @Const float[] beta,  
                                                       @Cast("cuComplex*") float2 C,
                                                       int ldc);  
                                      
public static native @Cast("cublasStatus_t") int cublasZher2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans, 
                                                       int n,
                                                       int k,
                                                       @Cast("const cuDoubleComplex*") double2 alpha,  
                                                       @Cast("const cuDoubleComplex*") double2 A, 
                                                       int lda,
                                                       @Cast("const cuDoubleComplex*") double2 B,
                                                       int ldb,
                                                       @Const DoublePointer beta,  
                                                       @Cast("cuDoubleComplex*") double2 C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasZher2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans, 
                                                       int n,
                                                       int k,
                                                       @Cast("const cuDoubleComplex*") double2 alpha,  
                                                       @Cast("const cuDoubleComplex*") double2 A, 
                                                       int lda,
                                                       @Cast("const cuDoubleComplex*") double2 B,
                                                       int ldb,
                                                       @Const DoubleBuffer beta,  
                                                       @Cast("cuDoubleComplex*") double2 C,
                                                       int ldc);
public static native @Cast("cublasStatus_t") int cublasZher2k_v2(cublasContext handle,
                                                       @Cast("cublasFillMode_t") int uplo,
                                                       @Cast("cublasOperation_t") int trans, 
                                                       int n,
                                                       int k,
                                                       @Cast("const cuDoubleComplex*") double2 alpha,  
                                                       @Cast("const cuDoubleComplex*") double2 A, 
                                                       int lda,
                                                       @Cast("const cuDoubleComplex*") double2 B,
                                                       int ldb,
                                                       @Const double[] beta,  
                                                       @Cast("cuDoubleComplex*") double2 C,
                                                       int ldc);     
/* SYRKX : eXtended SYRK*/
public static native @Cast("cublasStatus_t") int cublasSsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Const FloatPointer alpha, 
                                                    @Const FloatPointer A,
                                                    int lda,
                                                    @Const FloatPointer B,
                                                    int ldb,
                                                    @Const FloatPointer beta, 
                                                    FloatPointer C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasSsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Const FloatBuffer alpha, 
                                                    @Const FloatBuffer A,
                                                    int lda,
                                                    @Const FloatBuffer B,
                                                    int ldb,
                                                    @Const FloatBuffer beta, 
                                                    FloatBuffer C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasSsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Const float[] alpha, 
                                                    @Const float[] A,
                                                    int lda,
                                                    @Const float[] B,
                                                    int ldb,
                                                    @Const float[] beta, 
                                                    float[] C,
                                                    int ldc);
                                                   
public static native @Cast("cublasStatus_t") int cublasDsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Const DoublePointer alpha, 
                                                    @Const DoublePointer A,
                                                    int lda,
                                                    @Const DoublePointer B,
                                                    int ldb,
                                                    @Const DoublePointer beta, 
                                                    DoublePointer C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasDsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Const DoubleBuffer alpha, 
                                                    @Const DoubleBuffer A,
                                                    int lda,
                                                    @Const DoubleBuffer B,
                                                    int ldb,
                                                    @Const DoubleBuffer beta, 
                                                    DoubleBuffer C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasDsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Const double[] alpha, 
                                                    @Const double[] A,
                                                    int lda,
                                                    @Const double[] B,
                                                    int ldb,
                                                    @Const double[] beta, 
                                                    double[] C,
                                                    int ldc);
                                                    
public static native @Cast("cublasStatus_t") int cublasCsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuComplex*") float2 alpha, 
                                                    @Cast("const cuComplex*") float2 A,
                                                    int lda,
                                                    @Cast("const cuComplex*") float2 B,
                                                    int ldb,
                                                    @Cast("const cuComplex*") float2 beta, 
                                                    @Cast("cuComplex*") float2 C, 
                                                    int ldc);
                                                    
public static native @Cast("cublasStatus_t") int cublasZsyrkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo, 
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuDoubleComplex*") double2 alpha, 
                                                    @Cast("const cuDoubleComplex*") double2 A,
                                                    int lda,
                                                    @Cast("const cuDoubleComplex*") double2 B,
                                                    int ldb,
                                                    @Cast("const cuDoubleComplex*") double2 beta, 
                                                    @Cast("cuDoubleComplex*") double2 C, 
                                                    int ldc);
/* HERKX : eXtended HERK */
public static native @Cast("cublasStatus_t") int cublasCherkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuComplex*") float2 alpha, 
                                                    @Cast("const cuComplex*") float2 A,
                                                    int lda,
                                                    @Cast("const cuComplex*") float2 B,
                                                    int ldb,
                                                    @Const FloatPointer beta, 
                                                    @Cast("cuComplex*") float2 C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasCherkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuComplex*") float2 alpha, 
                                                    @Cast("const cuComplex*") float2 A,
                                                    int lda,
                                                    @Cast("const cuComplex*") float2 B,
                                                    int ldb,
                                                    @Const FloatBuffer beta, 
                                                    @Cast("cuComplex*") float2 C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasCherkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuComplex*") float2 alpha, 
                                                    @Cast("const cuComplex*") float2 A,
                                                    int lda,
                                                    @Cast("const cuComplex*") float2 B,
                                                    int ldb,
                                                    @Const float[] beta, 
                                                    @Cast("cuComplex*") float2 C,
                                                    int ldc);
                                                
public static native @Cast("cublasStatus_t") int cublasZherkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuDoubleComplex*") double2 alpha, 
                                                    @Cast("const cuDoubleComplex*") double2 A,
                                                    int lda,
                                                    @Cast("const cuDoubleComplex*") double2 B,
                                                    int ldb,
                                                    @Const DoublePointer beta, 
                                                    @Cast("cuDoubleComplex*") double2 C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasZherkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuDoubleComplex*") double2 alpha, 
                                                    @Cast("const cuDoubleComplex*") double2 A,
                                                    int lda,
                                                    @Cast("const cuDoubleComplex*") double2 B,
                                                    int ldb,
                                                    @Const DoubleBuffer beta, 
                                                    @Cast("cuDoubleComplex*") double2 C,
                                                    int ldc);
public static native @Cast("cublasStatus_t") int cublasZherkx(cublasContext handle,
                                                    @Cast("cublasFillMode_t") int uplo,
                                                    @Cast("cublasOperation_t") int trans,
                                                    int n,
                                                    int k,
                                                    @Cast("const cuDoubleComplex*") double2 alpha, 
                                                    @Cast("const cuDoubleComplex*") double2 A,
                                                    int lda,
                                                    @Cast("const cuDoubleComplex*") double2 B,
                                                    int ldb,
                                                    @Const double[] beta, 
                                                    @Cast("cuDoubleComplex*") double2 C,
                                                    int ldc);
/* SYMM */
public static native @Cast("cublasStatus_t") int cublasSsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer A,
                                                      int lda,
                                                      @Const FloatPointer B,
                                                      int ldb,
                                                      @Const FloatPointer beta,  
                                                      FloatPointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasSsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer A,
                                                      int lda,
                                                      @Const FloatBuffer B,
                                                      int ldb,
                                                      @Const FloatBuffer beta,  
                                                      FloatBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasSsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Const float[] alpha,  
                                                      @Const float[] A,
                                                      int lda,
                                                      @Const float[] B,
                                                      int ldb,
                                                      @Const float[] beta,  
                                                      float[] C,
                                                      int ldc);
                                     
public static native @Cast("cublasStatus_t") int cublasDsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m, 
                                                      int n,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer A,
                                                      int lda,
                                                      @Const DoublePointer B,
                                                      int ldb,
                                                      @Const DoublePointer beta,  
                                                      DoublePointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m, 
                                                      int n,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer A,
                                                      int lda,
                                                      @Const DoubleBuffer B,
                                                      int ldb,
                                                      @Const DoubleBuffer beta,  
                                                      DoubleBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m, 
                                                      int n,
                                                      @Const double[] alpha,  
                                                      @Const double[] A,
                                                      int lda,
                                                      @Const double[] B,
                                                      int ldb,
                                                      @Const double[] beta,  
                                                      double[] C,
                                                      int ldc);                                     

public static native @Cast("cublasStatus_t") int cublasCsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 B,
                                                      int ldb,
                                                      @Cast("const cuComplex*") float2 beta,  
                                                      @Cast("cuComplex*") float2 C,
                                                      int ldc);
                                                   
public static native @Cast("cublasStatus_t") int cublasZsymm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 B,
                                                      int ldb,
                                                      @Cast("const cuDoubleComplex*") double2 beta,  
                                                      @Cast("cuDoubleComplex*") double2 C,
                                                      int ldc);   
                                     
/* HEMM */
public static native @Cast("cublasStatus_t") int cublasChemm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Cast("const cuComplex*") float2 alpha,  
                                                      @Cast("const cuComplex*") float2 A,
                                                      int lda,
                                                      @Cast("const cuComplex*") float2 B,
                                                      int ldb,
                                                      @Cast("const cuComplex*") float2 beta,  
                                                      @Cast("cuComplex*") float2 C, 
                                                      int ldc); 

public static native @Cast("cublasStatus_t") int cublasZhemm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      int m,
                                                      int n,
                                                      @Cast("const cuDoubleComplex*") double2 alpha,  
                                                      @Cast("const cuDoubleComplex*") double2 A,
                                                      int lda,
                                                      @Cast("const cuDoubleComplex*") double2 B,
                                                      int ldb,
                                                      @Cast("const cuDoubleComplex*") double2 beta,  
                                                      @Cast("cuDoubleComplex*") double2 C,
                                                      int ldc); 
    
/* TRSM */                                                                         
public static native @Cast("cublasStatus_t") int cublasStrsm_v2(cublasContext handle, 
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer A,
                                                      int lda,
                                                      FloatPointer B,
                                                      int ldb);
public static native @Cast("cublasStatus_t") int cublasStrsm_v2(cublasContext handle, 
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer A,
                                                      int lda,
                                                      FloatBuffer B,
                                                      int ldb);
public static native @Cast("cublasStatus_t") int cublasStrsm_v2(cublasContext handle, 
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const float[] alpha,  
                                                      @Const float[] A,
                                                      int lda,
                                                      float[] B,
                                                      int ldb);
    

public static native @Cast("cublasStatus_t") int cublasDtrsm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer A, 
                                                      int lda, 
                                                      DoublePointer B,
                                                      int ldb);
public static native @Cast("cublasStatus_t") int cublasDtrsm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer A, 
                                                      int lda, 
                                                      DoubleBuffer B,
                                                      int ldb);
public static native @Cast("cublasStatus_t") int cublasDtrsm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const double[] alpha,  
                                                      @Const double[] A, 
                                                      int lda, 
                                                      double[] B,
                                                      int ldb);
    
public static native @Cast("cublasStatus_t") int cublasCtrsm_v2(cublasContext handle,
                                                     @Cast("cublasSideMode_t") int side,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     @Cast("cublasOperation_t") int trans,
                                                     @Cast("cublasDiagType_t") int diag,
                                                     int m,
                                                     int n,
                                                     @Cast("const cuComplex*") float2 alpha,  
                                                     @Cast("const cuComplex*") float2 A,
                                                     int lda,
                                                     @Cast("cuComplex*") float2 B,
                                                     int ldb);
                  
public static native @Cast("cublasStatus_t") int cublasZtrsm_v2(cublasContext handle, 
                                                     @Cast("cublasSideMode_t") int side,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     @Cast("cublasOperation_t") int trans,
                                                     @Cast("cublasDiagType_t") int diag,
                                                     int m,
                                                     int n,
                                                     @Cast("const cuDoubleComplex*") double2 alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 A,                                        
                                                     int lda,
                                                     @Cast("cuDoubleComplex*") double2 B,
                                                     int ldb);              
                                                
 /* TRMM */  
public static native @Cast("cublasStatus_t") int cublasStrmm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const FloatPointer alpha,  
                                                      @Const FloatPointer A,
                                                      int lda, 
                                                      @Const FloatPointer B,
                                                      int ldb,
                                                      FloatPointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasStrmm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const FloatBuffer alpha,  
                                                      @Const FloatBuffer A,
                                                      int lda, 
                                                      @Const FloatBuffer B,
                                                      int ldb,
                                                      FloatBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasStrmm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const float[] alpha,  
                                                      @Const float[] A,
                                                      int lda, 
                                                      @Const float[] B,
                                                      int ldb,
                                                      float[] C,
                                                      int ldc);
                                               
public static native @Cast("cublasStatus_t") int cublasDtrmm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const DoublePointer alpha,  
                                                      @Const DoublePointer A,
                                                      int lda,
                                                      @Const DoublePointer B,
                                                      int ldb,
                                                      DoublePointer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDtrmm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const DoubleBuffer alpha,  
                                                      @Const DoubleBuffer A,
                                                      int lda,
                                                      @Const DoubleBuffer B,
                                                      int ldb,
                                                      DoubleBuffer C,
                                                      int ldc);
public static native @Cast("cublasStatus_t") int cublasDtrmm_v2(cublasContext handle,
                                                      @Cast("cublasSideMode_t") int side,
                                                      @Cast("cublasFillMode_t") int uplo,
                                                      @Cast("cublasOperation_t") int trans,
                                                      @Cast("cublasDiagType_t") int diag,
                                                      int m,
                                                      int n,
                                                      @Const double[] alpha,  
                                                      @Const double[] A,
                                                      int lda,
                                                      @Const double[] B,
                                                      int ldb,
                                                      double[] C,
                                                      int ldc);
                                     
public static native @Cast("cublasStatus_t") int cublasCtrmm_v2(cublasContext handle,
                                                     @Cast("cublasSideMode_t") int side,
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     @Cast("cublasOperation_t") int trans,
                                                     @Cast("cublasDiagType_t") int diag,
                                                     int m,
                                                     int n,
                                                     @Cast("const cuComplex*") float2 alpha,  
                                                     @Cast("const cuComplex*") float2 A,
                                                     int lda,
                                                     @Cast("const cuComplex*") float2 B,
                                                     int ldb,
                                                     @Cast("cuComplex*") float2 C,
                                                     int ldc);
                  
public static native @Cast("cublasStatus_t") int cublasZtrmm_v2(cublasContext handle, @Cast("cublasSideMode_t") int side, 
                                                     @Cast("cublasFillMode_t") int uplo,
                                                     @Cast("cublasOperation_t") int trans,
                                                     @Cast("cublasDiagType_t") int diag,
                                                     int m,
                                                     int n,
                                                     @Cast("const cuDoubleComplex*") double2 alpha,  
                                                     @Cast("const cuDoubleComplex*") double2 A,
                                                     int lda,
                                                     @Cast("const cuDoubleComplex*") double2 B,
                                                     int ldb,
                                                     @Cast("cuDoubleComplex*") double2 C,
                                                     int ldc);
/* BATCH GEMM */
public static native @Cast("cublasStatus_t") int cublasSgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const FloatPointer alpha,  
                                                          @Cast("const float**") PointerPointer Aarray, 
                                                          int lda,
                                                          @Cast("const float**") PointerPointer Barray,
                                                          int ldb, 
                                                          @Const FloatPointer beta,  
                                                          @Cast("float**") PointerPointer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasSgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const FloatPointer alpha,  
                                                          @Const @ByPtrPtr FloatPointer Aarray, 
                                                          int lda,
                                                          @Const @ByPtrPtr FloatPointer Barray,
                                                          int ldb, 
                                                          @Const FloatPointer beta,  
                                                          @ByPtrPtr FloatPointer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasSgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const FloatBuffer alpha,  
                                                          @Const @ByPtrPtr FloatBuffer Aarray, 
                                                          int lda,
                                                          @Const @ByPtrPtr FloatBuffer Barray,
                                                          int ldb, 
                                                          @Const FloatBuffer beta,  
                                                          @ByPtrPtr FloatBuffer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasSgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const float[] alpha,  
                                                          @Const @ByPtrPtr float[] Aarray, 
                                                          int lda,
                                                          @Const @ByPtrPtr float[] Barray,
                                                          int ldb, 
                                                          @Const float[] beta,  
                                                          @ByPtrPtr float[] Carray,
                                                          int ldc,
                                                          int batchCount);

public static native @Cast("cublasStatus_t") int cublasDgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const DoublePointer alpha, 
                                                          @Cast("const double**") PointerPointer Aarray, 
                                                          int lda,
                                                          @Cast("const double**") PointerPointer Barray,
                                                          int ldb, 
                                                          @Const DoublePointer beta, 
                                                          @Cast("double**") PointerPointer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasDgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const DoublePointer alpha, 
                                                          @Const @ByPtrPtr DoublePointer Aarray, 
                                                          int lda,
                                                          @Const @ByPtrPtr DoublePointer Barray,
                                                          int ldb, 
                                                          @Const DoublePointer beta, 
                                                          @ByPtrPtr DoublePointer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasDgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const DoubleBuffer alpha, 
                                                          @Const @ByPtrPtr DoubleBuffer Aarray, 
                                                          int lda,
                                                          @Const @ByPtrPtr DoubleBuffer Barray,
                                                          int ldb, 
                                                          @Const DoubleBuffer beta, 
                                                          @ByPtrPtr DoubleBuffer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasDgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Const double[] alpha, 
                                                          @Const @ByPtrPtr double[] Aarray, 
                                                          int lda,
                                                          @Const @ByPtrPtr double[] Barray,
                                                          int ldb, 
                                                          @Const double[] beta, 
                                                          @ByPtrPtr double[] Carray,
                                                          int ldc,
                                                          int batchCount);

public static native @Cast("cublasStatus_t") int cublasCgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Cast("const cuComplex*") float2 alpha, 
                                                          @Cast("const cuComplex**") PointerPointer Aarray, 
                                                          int lda,
                                                          @Cast("const cuComplex**") PointerPointer Barray,
                                                          int ldb, 
                                                          @Cast("const cuComplex*") float2 beta, 
                                                          @Cast("cuComplex**") PointerPointer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasCgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Cast("const cuComplex*") float2 alpha, 
                                                          @Cast("const cuComplex**") @ByPtrPtr float2 Aarray, 
                                                          int lda,
                                                          @Cast("const cuComplex**") @ByPtrPtr float2 Barray,
                                                          int ldb, 
                                                          @Cast("const cuComplex*") float2 beta, 
                                                          @Cast("cuComplex**") @ByPtrPtr float2 Carray,
                                                          int ldc,
                                                          int batchCount);

public static native @Cast("cublasStatus_t") int cublasZgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Cast("const cuDoubleComplex*") double2 alpha, 
                                                          @Cast("const cuDoubleComplex**") PointerPointer Aarray, 
                                                          int lda,
                                                          @Cast("const cuDoubleComplex**") PointerPointer Barray,
                                                          int ldb, 
                                                          @Cast("const cuDoubleComplex*") double2 beta, 
                                                          @Cast("cuDoubleComplex**") PointerPointer Carray,
                                                          int ldc,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasZgemmBatched(cublasContext handle,
                                                          @Cast("cublasOperation_t") int transa,
                                                          @Cast("cublasOperation_t") int transb, 
                                                          int m,
                                                          int n,
                                                          int k,
                                                          @Cast("const cuDoubleComplex*") double2 alpha, 
                                                          @Cast("const cuDoubleComplex**") @ByPtrPtr double2 Aarray, 
                                                          int lda,
                                                          @Cast("const cuDoubleComplex**") @ByPtrPtr double2 Barray,
                                                          int ldb, 
                                                          @Cast("const cuDoubleComplex*") double2 beta, 
                                                          @Cast("cuDoubleComplex**") @ByPtrPtr double2 Carray,
                                                          int ldc,
                                                          int batchCount); 

/* ---------------- CUBLAS BLAS-like extension ---------------- */
/* GEAM */
public static native @Cast("cublasStatus_t") int cublasSgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Const FloatPointer alpha, 
                                                  @Const FloatPointer A, 
                                                  int lda,
                                                  @Const FloatPointer beta, 
                                                  @Const FloatPointer B, 
                                                  int ldb,
                                                  FloatPointer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasSgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Const FloatBuffer alpha, 
                                                  @Const FloatBuffer A, 
                                                  int lda,
                                                  @Const FloatBuffer beta, 
                                                  @Const FloatBuffer B, 
                                                  int ldb,
                                                  FloatBuffer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasSgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Const float[] alpha, 
                                                  @Const float[] A, 
                                                  int lda,
                                                  @Const float[] beta, 
                                                  @Const float[] B, 
                                                  int ldb,
                                                  float[] C, 
                                                  int ldc);
    
public static native @Cast("cublasStatus_t") int cublasDgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Const DoublePointer alpha, 
                                                  @Const DoublePointer A, 
                                                  int lda,
                                                  @Const DoublePointer beta, 
                                                  @Const DoublePointer B, 
                                                  int ldb,
                                                  DoublePointer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasDgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Const DoubleBuffer alpha, 
                                                  @Const DoubleBuffer A, 
                                                  int lda,
                                                  @Const DoubleBuffer beta, 
                                                  @Const DoubleBuffer B, 
                                                  int ldb,
                                                  DoubleBuffer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasDgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Const double[] alpha, 
                                                  @Const double[] A, 
                                                  int lda,
                                                  @Const double[] beta, 
                                                  @Const double[] B, 
                                                  int ldb,
                                                  double[] C, 
                                                  int ldc);

public static native @Cast("cublasStatus_t") int cublasCgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Cast("const cuComplex*") float2 alpha, 
                                                  @Cast("const cuComplex*") float2 A, 
                                                  int lda,
                                                  @Cast("const cuComplex*") float2 beta,  
                                                  @Cast("const cuComplex*") float2 B, 
                                                  int ldb,
                                                  @Cast("cuComplex*") float2 C, 
                                                  int ldc);

public static native @Cast("cublasStatus_t") int cublasZgeam(cublasContext handle,
                                                  @Cast("cublasOperation_t") int transa, 
                                                  @Cast("cublasOperation_t") int transb,
                                                  int m, 
                                                  int n,
                                                  @Cast("const cuDoubleComplex*") double2 alpha, 
                                                  @Cast("const cuDoubleComplex*") double2 A, 
                                                  int lda,
                                                  @Cast("const cuDoubleComplex*") double2 beta,  
                                                  @Cast("const cuDoubleComplex*") double2 B, 
                                                  int ldb,
                                                  @Cast("cuDoubleComplex*") double2 C, 
                                                  int ldc);
 
/* Batched LU - GETRF*/
public static native @Cast("cublasStatus_t") int cublasSgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("float**") PointerPointer A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @ByPtrPtr FloatPointer A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @ByPtrPtr FloatBuffer A,
                                                  int lda, 
                                                  IntBuffer P,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @ByPtrPtr float[] A,
                                                  int lda, 
                                                  int[] P,
                                                  int[] info,
                                                  int batchSize);

public static native @Cast("cublasStatus_t") int cublasDgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("double**") PointerPointer A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @ByPtrPtr DoublePointer A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @ByPtrPtr DoubleBuffer A,
                                                  int lda, 
                                                  IntBuffer P,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @ByPtrPtr double[] A,
                                                  int lda, 
                                                  int[] P,
                                                  int[] info,
                                                  int batchSize);

public static native @Cast("cublasStatus_t") int cublasCgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuComplex**") PointerPointer A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuComplex**") @ByPtrPtr float2 A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuComplex**") @ByPtrPtr float2 A,
                                                  int lda, 
                                                  IntBuffer P,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuComplex**") @ByPtrPtr float2 A,
                                                  int lda, 
                                                  int[] P,
                                                  int[] info,
                                                  int batchSize);

public static native @Cast("cublasStatus_t") int cublasZgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuDoubleComplex**") PointerPointer A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuDoubleComplex**") @ByPtrPtr double2 A,
                                                  int lda, 
                                                  IntPointer P,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuDoubleComplex**") @ByPtrPtr double2 A,
                                                  int lda, 
                                                  IntBuffer P,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgetrfBatched(cublasContext handle,
                                                  int n, 
                                                  @Cast("cuDoubleComplex**") @ByPtrPtr double2 A,
                                                  int lda, 
                                                  int[] P,
                                                  int[] info,
                                                  int batchSize);

/* Batched inversion based on LU factorization from getrf */
public static native @Cast("cublasStatus_t") int cublasSgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const float**") PointerPointer A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @Cast("float**") PointerPointer C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Const @ByPtrPtr FloatPointer A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @ByPtrPtr FloatPointer C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Const @ByPtrPtr FloatBuffer A,
                                                  int lda,
                                                  @Const IntBuffer P,
                                                  @ByPtrPtr FloatBuffer C,
                                                  int ldc,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Const @ByPtrPtr float[] A,
                                                  int lda,
                                                  @Const int[] P,
                                                  @ByPtrPtr float[] C,
                                                  int ldc,
                                                  int[] info,
                                                  int batchSize);

public static native @Cast("cublasStatus_t") int cublasDgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const double**") PointerPointer A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @Cast("double**") PointerPointer C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Const @ByPtrPtr DoublePointer A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @ByPtrPtr DoublePointer C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Const @ByPtrPtr DoubleBuffer A,
                                                  int lda,
                                                  @Const IntBuffer P,
                                                  @ByPtrPtr DoubleBuffer C,
                                                  int ldc,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Const @ByPtrPtr double[] A,
                                                  int lda,
                                                  @Const int[] P,
                                                  @ByPtrPtr double[] C,
                                                  int ldc,
                                                  int[] info,
                                                  int batchSize);

public static native @Cast("cublasStatus_t") int cublasCgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuComplex**") PointerPointer A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @Cast("cuComplex**") PointerPointer C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuComplex**") @ByPtrPtr float2 A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @Cast("cuComplex**") @ByPtrPtr float2 C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuComplex**") @ByPtrPtr float2 A,
                                                  int lda,
                                                  @Const IntBuffer P,
                                                  @Cast("cuComplex**") @ByPtrPtr float2 C,
                                                  int ldc,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuComplex**") @ByPtrPtr float2 A,
                                                  int lda,
                                                  @Const int[] P,
                                                  @Cast("cuComplex**") @ByPtrPtr float2 C,
                                                  int ldc,
                                                  int[] info,
                                                  int batchSize);

public static native @Cast("cublasStatus_t") int cublasZgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuDoubleComplex**") PointerPointer A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @Cast("cuDoubleComplex**") PointerPointer C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A,
                                                  int lda,
                                                  @Const IntPointer P,
                                                  @Cast("cuDoubleComplex**") @ByPtrPtr double2 C,
                                                  int ldc,
                                                  IntPointer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A,
                                                  int lda,
                                                  @Const IntBuffer P,
                                                  @Cast("cuDoubleComplex**") @ByPtrPtr double2 C,
                                                  int ldc,
                                                  IntBuffer info,
                                                  int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgetriBatched(cublasContext handle,
                                                  int n,
                                                  @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A,
                                                  int lda,
                                                  @Const int[] P,
                                                  @Cast("cuDoubleComplex**") @ByPtrPtr double2 C,
                                                  int ldc,
                                                  int[] info,
                                                  int batchSize);



/* TRSM - Batched Triangular Solver */
public static native @Cast("cublasStatus_t") int cublasStrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const FloatPointer alpha,
                                                          @Cast("const float**") PointerPointer A, 
                                                          int lda,
                                                          @Cast("float**") PointerPointer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasStrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const FloatPointer alpha,
                                                          @Const @ByPtrPtr FloatPointer A, 
                                                          int lda,
                                                          @ByPtrPtr FloatPointer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasStrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const FloatBuffer alpha,
                                                          @Const @ByPtrPtr FloatBuffer A, 
                                                          int lda,
                                                          @ByPtrPtr FloatBuffer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasStrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const float[] alpha,
                                                          @Const @ByPtrPtr float[] A, 
                                                          int lda,
                                                          @ByPtrPtr float[] B, 
                                                          int ldb,
                                                          int batchCount);

public static native @Cast("cublasStatus_t") int cublasDtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const DoublePointer alpha,
                                                          @Cast("const double**") PointerPointer A, 
                                                          int lda,
                                                          @Cast("double**") PointerPointer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasDtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const DoublePointer alpha,
                                                          @Const @ByPtrPtr DoublePointer A, 
                                                          int lda,
                                                          @ByPtrPtr DoublePointer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasDtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const DoubleBuffer alpha,
                                                          @Const @ByPtrPtr DoubleBuffer A, 
                                                          int lda,
                                                          @ByPtrPtr DoubleBuffer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasDtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Const double[] alpha,
                                                          @Const @ByPtrPtr double[] A, 
                                                          int lda,
                                                          @ByPtrPtr double[] B, 
                                                          int ldb,
                                                          int batchCount);

public static native @Cast("cublasStatus_t") int cublasCtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Cast("const cuComplex*") float2 alpha,
                                                          @Cast("const cuComplex**") PointerPointer A, 
                                                          int lda,
                                                          @Cast("cuComplex**") PointerPointer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasCtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Cast("const cuComplex*") float2 alpha,
                                                          @Cast("const cuComplex**") @ByPtrPtr float2 A, 
                                                          int lda,
                                                          @Cast("cuComplex**") @ByPtrPtr float2 B, 
                                                          int ldb,
                                                          int batchCount);

public static native @Cast("cublasStatus_t") int cublasZtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Cast("const cuDoubleComplex*") double2 alpha,
                                                          @Cast("const cuDoubleComplex**") PointerPointer A, 
                                                          int lda,
                                                          @Cast("cuDoubleComplex**") PointerPointer B, 
                                                          int ldb,
                                                          int batchCount);
public static native @Cast("cublasStatus_t") int cublasZtrsmBatched( cublasContext handle, 
                                                          @Cast("cublasSideMode_t") int side, 
                                                          @Cast("cublasFillMode_t") int uplo,
                                                          @Cast("cublasOperation_t") int trans, 
                                                          @Cast("cublasDiagType_t") int diag,
                                                          int m, 
                                                          int n, 
                                                          @Cast("const cuDoubleComplex*") double2 alpha,
                                                          @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A, 
                                                          int lda,
                                                          @Cast("cuDoubleComplex**") @ByPtrPtr double2 B, 
                                                          int ldb,
                                                          int batchCount);

/* Batched - MATINV*/
public static native @Cast("cublasStatus_t") int cublasSmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const float**") PointerPointer A,
                                                          int lda, 
                                                          @Cast("float**") PointerPointer Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasSmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Const @ByPtrPtr FloatPointer A,
                                                          int lda, 
                                                          @ByPtrPtr FloatPointer Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasSmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Const @ByPtrPtr FloatBuffer A,
                                                          int lda, 
                                                          @ByPtrPtr FloatBuffer Ainv,
                                                          int lda_inv, 
                                                          IntBuffer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasSmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Const @ByPtrPtr float[] A,
                                                          int lda, 
                                                          @ByPtrPtr float[] Ainv,
                                                          int lda_inv, 
                                                          int[] info,
                                                          int batchSize);

public static native @Cast("cublasStatus_t") int cublasDmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const double**") PointerPointer A,
                                                          int lda, 
                                                          @Cast("double**") PointerPointer Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasDmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Const @ByPtrPtr DoublePointer A,
                                                          int lda, 
                                                          @ByPtrPtr DoublePointer Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasDmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Const @ByPtrPtr DoubleBuffer A,
                                                          int lda, 
                                                          @ByPtrPtr DoubleBuffer Ainv,
                                                          int lda_inv, 
                                                          IntBuffer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasDmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Const @ByPtrPtr double[] A,
                                                          int lda, 
                                                          @ByPtrPtr double[] Ainv,
                                                          int lda_inv, 
                                                          int[] info,
                                                          int batchSize);

public static native @Cast("cublasStatus_t") int cublasCmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuComplex**") PointerPointer A,
                                                          int lda, 
                                                          @Cast("cuComplex**") PointerPointer Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasCmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuComplex**") @ByPtrPtr float2 A,
                                                          int lda, 
                                                          @Cast("cuComplex**") @ByPtrPtr float2 Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasCmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuComplex**") @ByPtrPtr float2 A,
                                                          int lda, 
                                                          @Cast("cuComplex**") @ByPtrPtr float2 Ainv,
                                                          int lda_inv, 
                                                          IntBuffer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasCmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuComplex**") @ByPtrPtr float2 A,
                                                          int lda, 
                                                          @Cast("cuComplex**") @ByPtrPtr float2 Ainv,
                                                          int lda_inv, 
                                                          int[] info,
                                                          int batchSize);

public static native @Cast("cublasStatus_t") int cublasZmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuDoubleComplex**") PointerPointer A,
                                                          int lda, 
                                                          @Cast("cuDoubleComplex**") PointerPointer Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasZmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A,
                                                          int lda, 
                                                          @Cast("cuDoubleComplex**") @ByPtrPtr double2 Ainv,
                                                          int lda_inv, 
                                                          IntPointer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasZmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A,
                                                          int lda, 
                                                          @Cast("cuDoubleComplex**") @ByPtrPtr double2 Ainv,
                                                          int lda_inv, 
                                                          IntBuffer info,
                                                          int batchSize);
public static native @Cast("cublasStatus_t") int cublasZmatinvBatched(cublasContext handle,
                                                          int n, 
                                                          @Cast("const cuDoubleComplex**") @ByPtrPtr double2 A,
                                                          int lda, 
                                                          @Cast("cuDoubleComplex**") @ByPtrPtr double2 Ainv,
                                                          int lda_inv, 
                                                          int[] info,
                                                          int batchSize);

/* Batch QR Factorization */
public static native @Cast("cublasStatus_t") int cublasSgeqrfBatched( cublasContext handle, 
                                                           int m, 
                                                           int n,
                                                           @Cast("float**") PointerPointer Aarray,
                                                           int lda, 
                                                           @Cast("float**") PointerPointer TauArray,                                                           
                                                           IntPointer info,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgeqrfBatched( cublasContext handle, 
                                                           int m, 
                                                           int n,
                                                           @ByPtrPtr FloatPointer Aarray,
                                                           int lda, 
                                                           @ByPtrPtr FloatPointer TauArray,                                                           
                                                           IntPointer info,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgeqrfBatched( cublasContext handle, 
                                                           int m, 
                                                           int n,
                                                           @ByPtrPtr FloatBuffer Aarray,
                                                           int lda, 
                                                           @ByPtrPtr FloatBuffer TauArray,                                                           
                                                           IntBuffer info,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasSgeqrfBatched( cublasContext handle, 
                                                           int m, 
                                                           int n,
                                                           @ByPtrPtr float[] Aarray,
                                                           int lda, 
                                                           @ByPtrPtr float[] TauArray,                                                           
                                                           int[] info,
                                                           int batchSize);

public static native @Cast("cublasStatus_t") int cublasDgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("double**") PointerPointer Aarray,
                                                            int lda, 
                                                            @Cast("double**") PointerPointer TauArray,                                                            
                                                            IntPointer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @ByPtrPtr DoublePointer Aarray,
                                                            int lda, 
                                                            @ByPtrPtr DoublePointer TauArray,                                                            
                                                            IntPointer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @ByPtrPtr DoubleBuffer Aarray,
                                                            int lda, 
                                                            @ByPtrPtr DoubleBuffer TauArray,                                                            
                                                            IntBuffer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @ByPtrPtr double[] Aarray,
                                                            int lda, 
                                                            @ByPtrPtr double[] TauArray,                                                            
                                                            int[] info,
                                                            int batchSize);

public static native @Cast("cublasStatus_t") int cublasCgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuComplex**") PointerPointer Aarray,
                                                            int lda, 
                                                            @Cast("cuComplex**") PointerPointer TauArray,                                                            
                                                            IntPointer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuComplex**") @ByPtrPtr float2 Aarray,
                                                            int lda, 
                                                            @Cast("cuComplex**") @ByPtrPtr float2 TauArray,                                                            
                                                            IntPointer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuComplex**") @ByPtrPtr float2 Aarray,
                                                            int lda, 
                                                            @Cast("cuComplex**") @ByPtrPtr float2 TauArray,                                                            
                                                            IntBuffer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuComplex**") @ByPtrPtr float2 Aarray,
                                                            int lda, 
                                                            @Cast("cuComplex**") @ByPtrPtr float2 TauArray,                                                            
                                                            int[] info,
                                                            int batchSize);
                                                            
public static native @Cast("cublasStatus_t") int cublasZgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuDoubleComplex**") PointerPointer Aarray,
                                                            int lda, 
                                                            @Cast("cuDoubleComplex**") PointerPointer TauArray,                                                          
                                                            IntPointer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuDoubleComplex**") @ByPtrPtr double2 Aarray,
                                                            int lda, 
                                                            @Cast("cuDoubleComplex**") @ByPtrPtr double2 TauArray,                                                          
                                                            IntPointer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuDoubleComplex**") @ByPtrPtr double2 Aarray,
                                                            int lda, 
                                                            @Cast("cuDoubleComplex**") @ByPtrPtr double2 TauArray,                                                          
                                                            IntBuffer info,
                                                            int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgeqrfBatched( cublasContext handle, 
                                                            int m, 
                                                            int n,
                                                            @Cast("cuDoubleComplex**") @ByPtrPtr double2 Aarray,
                                                            int lda, 
                                                            @Cast("cuDoubleComplex**") @ByPtrPtr double2 TauArray,                                                          
                                                            int[] info,
                                                            int batchSize);
/* Least Square Min only m >= n and Non-transpose supported */
public static native @Cast("cublasStatus_t") int cublasSgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("float**") PointerPointer Aarray,
                                                           int lda, 
                                                           @Cast("float**") PointerPointer Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize );
public static native @Cast("cublasStatus_t") int cublasSgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @ByPtrPtr FloatPointer Aarray,
                                                           int lda, 
                                                           @ByPtrPtr FloatPointer Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize );
public static native @Cast("cublasStatus_t") int cublasSgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @ByPtrPtr FloatBuffer Aarray,
                                                           int lda, 
                                                           @ByPtrPtr FloatBuffer Carray,
                                                           int ldc,                                                                 
                                                           IntBuffer info, 
                                                           IntBuffer devInfoArray,
                                                           int batchSize );
public static native @Cast("cublasStatus_t") int cublasSgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @ByPtrPtr float[] Aarray,
                                                           int lda, 
                                                           @ByPtrPtr float[] Carray,
                                                           int ldc,                                                                 
                                                           int[] info, 
                                                           int[] devInfoArray,
                                                           int batchSize );
                                                                
public static native @Cast("cublasStatus_t") int cublasDgelsBatched( cublasContext handle,
                                                           @Cast("cublasOperation_t") int trans,  
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("double**") PointerPointer Aarray,
                                                           int lda, 
                                                           @Cast("double**") PointerPointer Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgelsBatched( cublasContext handle,
                                                           @Cast("cublasOperation_t") int trans,  
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @ByPtrPtr DoublePointer Aarray,
                                                           int lda, 
                                                           @ByPtrPtr DoublePointer Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgelsBatched( cublasContext handle,
                                                           @Cast("cublasOperation_t") int trans,  
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @ByPtrPtr DoubleBuffer Aarray,
                                                           int lda, 
                                                           @ByPtrPtr DoubleBuffer Carray,
                                                           int ldc,                                                                 
                                                           IntBuffer info, 
                                                           IntBuffer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasDgelsBatched( cublasContext handle,
                                                           @Cast("cublasOperation_t") int trans,  
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @ByPtrPtr double[] Aarray,
                                                           int lda, 
                                                           @ByPtrPtr double[] Carray,
                                                           int ldc,                                                                 
                                                           int[] info, 
                                                           int[] devInfoArray,
                                                           int batchSize);
                                                                
public static native @Cast("cublasStatus_t") int cublasCgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuComplex**") PointerPointer Aarray,
                                                           int lda, 
                                                           @Cast("cuComplex**") PointerPointer Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuComplex**") @ByPtrPtr float2 Aarray,
                                                           int lda, 
                                                           @Cast("cuComplex**") @ByPtrPtr float2 Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuComplex**") @ByPtrPtr float2 Aarray,
                                                           int lda, 
                                                           @Cast("cuComplex**") @ByPtrPtr float2 Carray,
                                                           int ldc,                                                                 
                                                           IntBuffer info, 
                                                           IntBuffer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasCgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuComplex**") @ByPtrPtr float2 Aarray,
                                                           int lda, 
                                                           @Cast("cuComplex**") @ByPtrPtr float2 Carray,
                                                           int ldc,                                                                 
                                                           int[] info, 
                                                           int[] devInfoArray,
                                                           int batchSize);
                                                                
public static native @Cast("cublasStatus_t") int cublasZgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuDoubleComplex**") PointerPointer Aarray,
                                                           int lda, 
                                                           @Cast("cuDoubleComplex**") PointerPointer Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuDoubleComplex**") @ByPtrPtr double2 Aarray,
                                                           int lda, 
                                                           @Cast("cuDoubleComplex**") @ByPtrPtr double2 Carray,
                                                           int ldc,                                                                 
                                                           IntPointer info, 
                                                           IntPointer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuDoubleComplex**") @ByPtrPtr double2 Aarray,
                                                           int lda, 
                                                           @Cast("cuDoubleComplex**") @ByPtrPtr double2 Carray,
                                                           int ldc,                                                                 
                                                           IntBuffer info, 
                                                           IntBuffer devInfoArray,
                                                           int batchSize);
public static native @Cast("cublasStatus_t") int cublasZgelsBatched( cublasContext handle, 
                                                           @Cast("cublasOperation_t") int trans, 
                                                           int m,  
                                                           int n,
                                                           int nrhs,
                                                           @Cast("cuDoubleComplex**") @ByPtrPtr double2 Aarray,
                                                           int lda, 
                                                           @Cast("cuDoubleComplex**") @ByPtrPtr double2 Carray,
                                                           int ldc,                                                                 
                                                           int[] info, 
                                                           int[] devInfoArray,
                                                           int batchSize);                                                                                                                                                                                                
/* DGMM */
public static native @Cast("cublasStatus_t") int cublasSdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Const FloatPointer A, 
                                                  int lda,
                                                  @Const FloatPointer x, 
                                                  int incx,
                                                  FloatPointer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasSdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Const FloatBuffer A, 
                                                  int lda,
                                                  @Const FloatBuffer x, 
                                                  int incx,
                                                  FloatBuffer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasSdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Const float[] A, 
                                                  int lda,
                                                  @Const float[] x, 
                                                  int incx,
                                                  float[] C, 
                                                  int ldc);
    
public static native @Cast("cublasStatus_t") int cublasDdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Const DoublePointer A, 
                                                  int lda,
                                                  @Const DoublePointer x, 
                                                  int incx,
                                                  DoublePointer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasDdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Const DoubleBuffer A, 
                                                  int lda,
                                                  @Const DoubleBuffer x, 
                                                  int incx,
                                                  DoubleBuffer C, 
                                                  int ldc);
public static native @Cast("cublasStatus_t") int cublasDdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Const double[] A, 
                                                  int lda,
                                                  @Const double[] x, 
                                                  int incx,
                                                  double[] C, 
                                                  int ldc);

public static native @Cast("cublasStatus_t") int cublasCdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Cast("const cuComplex*") float2 A, 
                                                  int lda,
                                                  @Cast("const cuComplex*") float2 x, 
                                                  int incx,
                                                  @Cast("cuComplex*") float2 C, 
                                                  int ldc);
    
public static native @Cast("cublasStatus_t") int cublasZdgmm(cublasContext handle,
                                                  @Cast("cublasSideMode_t") int mode, 
                                                  int m, 
                                                  int n,
                                                  @Cast("const cuDoubleComplex*") double2 A, 
                                                  int lda,
                                                  @Cast("const cuDoubleComplex*") double2 x, 
                                                  int incx,
                                                  @Cast("cuDoubleComplex*") double2 C, 
                                                  int ldc);

/* TPTTR : Triangular Pack format to Triangular format */
public static native @Cast("cublasStatus_t") int cublasStpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const FloatPointer AP,
                                                     FloatPointer A,  
                                                     int lda );
public static native @Cast("cublasStatus_t") int cublasStpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const FloatBuffer AP,
                                                     FloatBuffer A,  
                                                     int lda );
public static native @Cast("cublasStatus_t") int cublasStpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const float[] AP,
                                                     float[] A,  
                                                     int lda );
                                       
public static native @Cast("cublasStatus_t") int cublasDtpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const DoublePointer AP,
                                                     DoublePointer A,  
                                                     int lda );
public static native @Cast("cublasStatus_t") int cublasDtpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const DoubleBuffer AP,
                                                     DoubleBuffer A,  
                                                     int lda );
public static native @Cast("cublasStatus_t") int cublasDtpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const double[] AP,
                                                     double[] A,  
                                                     int lda );
                                      
public static native @Cast("cublasStatus_t") int cublasCtpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Cast("const cuComplex*") float2 AP,
                                                     @Cast("cuComplex*") float2 A,  
                                                     int lda );
                                                    
public static native @Cast("cublasStatus_t") int cublasZtpttr( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Cast("const cuDoubleComplex*") double2 AP,
                                                     @Cast("cuDoubleComplex*") double2 A,  
                                                     int lda );
 /* TRTTP : Triangular format to Triangular Pack format */                                      
public static native @Cast("cublasStatus_t") int cublasStrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const FloatPointer A,
                                                     int lda,
                                                     FloatPointer AP );
public static native @Cast("cublasStatus_t") int cublasStrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const FloatBuffer A,
                                                     int lda,
                                                     FloatBuffer AP );
public static native @Cast("cublasStatus_t") int cublasStrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const float[] A,
                                                     int lda,
                                                     float[] AP );
                                      
public static native @Cast("cublasStatus_t") int cublasDtrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const DoublePointer A,
                                                     int lda,
                                                     DoublePointer AP );
public static native @Cast("cublasStatus_t") int cublasDtrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const DoubleBuffer A,
                                                     int lda,
                                                     DoubleBuffer AP );
public static native @Cast("cublasStatus_t") int cublasDtrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Const double[] A,
                                                     int lda,
                                                     double[] AP );
                                      
public static native @Cast("cublasStatus_t") int cublasCtrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Cast("const cuComplex*") float2 A,
                                                     int lda,
                                                     @Cast("cuComplex*") float2 AP );
                                                     
public static native @Cast("cublasStatus_t") int cublasZtrttp( cublasContext handle, 
                                                     @Cast("cublasFillMode_t") int uplo, 
                                                     int n,                                     
                                                     @Cast("const cuDoubleComplex*") double2 A,
                                                     int lda,
                                                     @Cast("cuDoubleComplex*") double2 AP );                                        
                                      
// #if defined(__cplusplus)
// #endif /* __cplusplus */

// #endif /* !defined(CUBLAS_API_H_) */


// Parsed from <cublas.h>

/*
 * Copyright 1993-2014 NVIDIA Corporation.  All rights reserved.
 *
 * NOTICE TO LICENSEE:
 *
 * This source code and/or documentation ("Licensed Deliverables") are
 * subject to NVIDIA intellectual property rights under U.S. and
 * international Copyright laws.
 *
 * These Licensed Deliverables contained herein is PROPRIETARY and
 * CONFIDENTIAL to NVIDIA and is being provided under the terms and
 * conditions of a form of NVIDIA software license agreement by and
 * between NVIDIA and Licensee ("License Agreement") or electronically
 * accepted by Licensee.  Notwithstanding any terms or conditions to
 * the contrary in the License Agreement, reproduction or disclosure
 * of the Licensed Deliverables to any third party without the express
 * written consent of NVIDIA is prohibited.
 *
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, NVIDIA MAKES NO REPRESENTATION ABOUT THE
 * SUITABILITY OF THESE LICENSED DELIVERABLES FOR ANY PURPOSE.  IT IS
 * PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF ANY KIND.
 * NVIDIA DISCLAIMS ALL WARRANTIES WITH REGARD TO THESE LICENSED
 * DELIVERABLES, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NONINFRINGEMENT, AND FITNESS FOR A PARTICULAR PURPOSE.
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, IN NO EVENT SHALL NVIDIA BE LIABLE FOR ANY
 * SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, OR ANY
 * DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE
 * OF THESE LICENSED DELIVERABLES.
 *
 * U.S. Government End Users.  These Licensed Deliverables are a
 * "commercial item" as that term is defined at 48 C.F.R. 2.101 (OCT
 * 1995), consisting of "commercial computer software" and "commercial
 * computer software documentation" as such terms are used in 48
 * C.F.R. 12.212 (SEPT 1995) and is provided to the U.S. Government
 * only as a commercial end item.  Consistent with 48 C.F.R.12.212 and
 * 48 C.F.R. 227.7202-1 through 227.7202-4 (JUNE 1995), all
 * U.S. Government End Users acquire the Licensed Deliverables with
 * only those rights set forth herein.
 *
 * Any use of the Licensed Deliverables in individual and commercial
 * software must include, in the user documentation and internal
 * comments to the code, the above Disclaimer and U.S. Government End
 * Users Notice.
 */
 
/*
 * This is the public header file for the CUBLAS library, defining the API
 *
 * CUBLAS is an implementation of BLAS (Basic Linear Algebra Subroutines) 
 * on top of the CUDA runtime. 
 */

// #if !defined(CUBLAS_H_)
// #define CUBLAS_H_

// #include <cuda_runtime.h>

// #ifndef CUBLASWINAPI
// #ifdef _WIN32
// #define CUBLASWINAPI __stdcall
// #else
// #define CUBLASWINAPI 
// #endif
// #endif

// #undef CUBLASAPI
// #ifdef __CUDACC__
// #define CUBLASAPI __host__
// #else
// #define CUBLASAPI
// #endif

// #include "cublas_api.h"

// #if defined(__cplusplus)
// #endif

/* CUBLAS data types */
// #define cublasStatus cublasStatus_t

public static native @Cast("cublasStatus_t") int cublasInit();
public static native @Cast("cublasStatus_t") int cublasShutdown();
public static native @Cast("cublasStatus_t") int cublasGetError();

public static native @Cast("cublasStatus_t") int cublasGetVersion(IntPointer version);
public static native @Cast("cublasStatus_t") int cublasGetVersion(IntBuffer version);
public static native @Cast("cublasStatus_t") int cublasGetVersion(int[] version);
public static native @Cast("cublasStatus_t") int cublasAlloc(int n, int elemSize, @Cast("void**") PointerPointer devicePtr);
public static native @Cast("cublasStatus_t") int cublasAlloc(int n, int elemSize, @Cast("void**") @ByPtrPtr Pointer devicePtr);

public static native @Cast("cublasStatus_t") int cublasFree(Pointer devicePtr);


public static native @Cast("cublasStatus_t") int cublasSetKernelStream(CUstream_st stream);



/* ---------------- CUBLAS BLAS1 functions ---------------- */
/* NRM2 */
public static native float cublasSnrm2(int n, @Const FloatPointer x, int incx);
public static native float cublasSnrm2(int n, @Const FloatBuffer x, int incx);
public static native float cublasSnrm2(int n, @Const float[] x, int incx);
public static native double cublasDnrm2(int n, @Const DoublePointer x, int incx);
public static native double cublasDnrm2(int n, @Const DoubleBuffer x, int incx);
public static native double cublasDnrm2(int n, @Const double[] x, int incx);
public static native float cublasScnrm2(int n, @Cast("const cuComplex*") float2 x, int incx);
public static native double cublasDznrm2(int n, @Cast("const cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* DOT */
public static native float cublasSdot(int n, @Const FloatPointer x, int incx, @Const FloatPointer y, 
                               int incy);
public static native float cublasSdot(int n, @Const FloatBuffer x, int incx, @Const FloatBuffer y, 
                               int incy);
public static native float cublasSdot(int n, @Const float[] x, int incx, @Const float[] y, 
                               int incy);
public static native double cublasDdot(int n, @Const DoublePointer x, int incx, @Const DoublePointer y, 
                               int incy);
public static native double cublasDdot(int n, @Const DoubleBuffer x, int incx, @Const DoubleBuffer y, 
                               int incy);
public static native double cublasDdot(int n, @Const double[] x, int incx, @Const double[] y, 
                               int incy);
public static native @ByVal @Cast("cuComplex*") float2 cublasCdotu(int n, @Cast("const cuComplex*") float2 x, int incx, @Cast("const cuComplex*") float2 y, 
                               int incy);
public static native @ByVal @Cast("cuComplex*") float2 cublasCdotc(int n, @Cast("const cuComplex*") float2 x, int incx, @Cast("const cuComplex*") float2 y, 
                               int incy);
public static native @ByVal @Cast("cuDoubleComplex*") double2 cublasZdotu(int n, @Cast("const cuDoubleComplex*") double2 x, int incx, @Cast("const cuDoubleComplex*") double2 y, 
                               int incy);
public static native @ByVal @Cast("cuDoubleComplex*") double2 cublasZdotc(int n, @Cast("const cuDoubleComplex*") double2 x, int incx, @Cast("const cuDoubleComplex*") double2 y, 
                               int incy);
/*------------------------------------------------------------------------*/
/* SCAL */
public static native void cublasSscal(int n, float alpha, FloatPointer x, int incx);
public static native void cublasSscal(int n, float alpha, FloatBuffer x, int incx);
public static native void cublasSscal(int n, float alpha, float[] x, int incx);
public static native void cublasDscal(int n, double alpha, DoublePointer x, int incx);
public static native void cublasDscal(int n, double alpha, DoubleBuffer x, int incx);
public static native void cublasDscal(int n, double alpha, double[] x, int incx);
public static native void cublasCscal(int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("cuComplex*") float2 x, int incx);
public static native void cublasZscal(int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("cuDoubleComplex*") double2 x, int incx);

public static native void cublasCsscal(int n, float alpha, @Cast("cuComplex*") float2 x, int incx);
public static native void cublasZdscal(int n, double alpha, @Cast("cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* AXPY */
public static native void cublasSaxpy(int n, float alpha, @Const FloatPointer x, int incx, 
                               FloatPointer y, int incy);
public static native void cublasSaxpy(int n, float alpha, @Const FloatBuffer x, int incx, 
                               FloatBuffer y, int incy);
public static native void cublasSaxpy(int n, float alpha, @Const float[] x, int incx, 
                               float[] y, int incy);
public static native void cublasDaxpy(int n, double alpha, @Const DoublePointer x, 
                               int incx, DoublePointer y, int incy);
public static native void cublasDaxpy(int n, double alpha, @Const DoubleBuffer x, 
                               int incx, DoubleBuffer y, int incy);
public static native void cublasDaxpy(int n, double alpha, @Const double[] x, 
                               int incx, double[] y, int incy);
public static native void cublasCaxpy(int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 x, 
                               int incx, @Cast("cuComplex*") float2 y, int incy);
public static native void cublasZaxpy(int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 x, 
                               int incx, @Cast("cuDoubleComplex*") double2 y, int incy);
/*------------------------------------------------------------------------*/
/* COPY */
public static native void cublasScopy(int n, @Const FloatPointer x, int incx, FloatPointer y, 
                               int incy);
public static native void cublasScopy(int n, @Const FloatBuffer x, int incx, FloatBuffer y, 
                               int incy);
public static native void cublasScopy(int n, @Const float[] x, int incx, float[] y, 
                               int incy);
public static native void cublasDcopy(int n, @Const DoublePointer x, int incx, DoublePointer y, 
                               int incy);
public static native void cublasDcopy(int n, @Const DoubleBuffer x, int incx, DoubleBuffer y, 
                               int incy);
public static native void cublasDcopy(int n, @Const double[] x, int incx, double[] y, 
                               int incy);
public static native void cublasCcopy(int n, @Cast("const cuComplex*") float2 x, int incx, @Cast("cuComplex*") float2 y,
                               int incy);
public static native void cublasZcopy(int n, @Cast("const cuDoubleComplex*") double2 x, int incx, @Cast("cuDoubleComplex*") double2 y,
                               int incy);
/*------------------------------------------------------------------------*/
/* SWAP */
public static native void cublasSswap(int n, FloatPointer x, int incx, FloatPointer y, int incy);
public static native void cublasSswap(int n, FloatBuffer x, int incx, FloatBuffer y, int incy);
public static native void cublasSswap(int n, float[] x, int incx, float[] y, int incy);
public static native void cublasDswap(int n, DoublePointer x, int incx, DoublePointer y, int incy);
public static native void cublasDswap(int n, DoubleBuffer x, int incx, DoubleBuffer y, int incy);
public static native void cublasDswap(int n, double[] x, int incx, double[] y, int incy);
public static native void cublasCswap(int n, @Cast("cuComplex*") float2 x, int incx, @Cast("cuComplex*") float2 y, int incy);
public static native void cublasZswap(int n, @Cast("cuDoubleComplex*") double2 x, int incx, @Cast("cuDoubleComplex*") double2 y, int incy);           
/*------------------------------------------------------------------------*/
/* AMAX */
public static native int cublasIsamax(int n, @Const FloatPointer x, int incx);
public static native int cublasIsamax(int n, @Const FloatBuffer x, int incx);
public static native int cublasIsamax(int n, @Const float[] x, int incx);
public static native int cublasIdamax(int n, @Const DoublePointer x, int incx);
public static native int cublasIdamax(int n, @Const DoubleBuffer x, int incx);
public static native int cublasIdamax(int n, @Const double[] x, int incx);
public static native int cublasIcamax(int n, @Cast("const cuComplex*") float2 x, int incx);
public static native int cublasIzamax(int n, @Cast("const cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* AMIN */
public static native int cublasIsamin(int n, @Const FloatPointer x, int incx);
public static native int cublasIsamin(int n, @Const FloatBuffer x, int incx);
public static native int cublasIsamin(int n, @Const float[] x, int incx);
public static native int cublasIdamin(int n, @Const DoublePointer x, int incx);
public static native int cublasIdamin(int n, @Const DoubleBuffer x, int incx);
public static native int cublasIdamin(int n, @Const double[] x, int incx);

public static native int cublasIcamin(int n, @Cast("const cuComplex*") float2 x, int incx);
public static native int cublasIzamin(int n, @Cast("const cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* ASUM */
public static native float cublasSasum(int n, @Const FloatPointer x, int incx);
public static native float cublasSasum(int n, @Const FloatBuffer x, int incx);
public static native float cublasSasum(int n, @Const float[] x, int incx);
public static native double cublasDasum(int n, @Const DoublePointer x, int incx);
public static native double cublasDasum(int n, @Const DoubleBuffer x, int incx);
public static native double cublasDasum(int n, @Const double[] x, int incx);
public static native float cublasScasum(int n, @Cast("const cuComplex*") float2 x, int incx);
public static native double cublasDzasum(int n, @Cast("const cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* ROT */
public static native void cublasSrot(int n, FloatPointer x, int incx, FloatPointer y, int incy, 
                              float sc, float ss);
public static native void cublasSrot(int n, FloatBuffer x, int incx, FloatBuffer y, int incy, 
                              float sc, float ss);
public static native void cublasSrot(int n, float[] x, int incx, float[] y, int incy, 
                              float sc, float ss);
public static native void cublasDrot(int n, DoublePointer x, int incx, DoublePointer y, int incy, 
                              double sc, double ss);
public static native void cublasDrot(int n, DoubleBuffer x, int incx, DoubleBuffer y, int incy, 
                              double sc, double ss);
public static native void cublasDrot(int n, double[] x, int incx, double[] y, int incy, 
                              double sc, double ss);
public static native void cublasCrot(int n, @Cast("cuComplex*") float2 x, int incx, @Cast("cuComplex*") float2 y, 
                              int incy, float c, @ByVal @Cast("cuComplex*") float2 s);
public static native void cublasZrot(int n, @Cast("cuDoubleComplex*") double2 x, int incx, 
                              @Cast("cuDoubleComplex*") double2 y, int incy, double sc, 
                              @ByVal @Cast("cuDoubleComplex*") double2 cs);
public static native void cublasCsrot(int n, @Cast("cuComplex*") float2 x, int incx, @Cast("cuComplex*") float2 y,
                               int incy, float c, float s);
public static native void cublasZdrot(int n, @Cast("cuDoubleComplex*") double2 x, int incx, 
                               @Cast("cuDoubleComplex*") double2 y, int incy, double c, double s);
/*------------------------------------------------------------------------*/
/* ROTG */
public static native void cublasSrotg(FloatPointer sa, FloatPointer sb, FloatPointer sc, FloatPointer ss);
public static native void cublasSrotg(FloatBuffer sa, FloatBuffer sb, FloatBuffer sc, FloatBuffer ss);
public static native void cublasSrotg(float[] sa, float[] sb, float[] sc, float[] ss);
public static native void cublasDrotg(DoublePointer sa, DoublePointer sb, DoublePointer sc, DoublePointer ss);
public static native void cublasDrotg(DoubleBuffer sa, DoubleBuffer sb, DoubleBuffer sc, DoubleBuffer ss);
public static native void cublasDrotg(double[] sa, double[] sb, double[] sc, double[] ss);
public static native void cublasCrotg(@Cast("cuComplex*") float2 ca, @ByVal @Cast("cuComplex*") float2 cb, FloatPointer sc,
                               @Cast("cuComplex*") float2 cs);
public static native void cublasCrotg(@Cast("cuComplex*") float2 ca, @ByVal @Cast("cuComplex*") float2 cb, FloatBuffer sc,
                               @Cast("cuComplex*") float2 cs);
public static native void cublasCrotg(@Cast("cuComplex*") float2 ca, @ByVal @Cast("cuComplex*") float2 cb, float[] sc,
                               @Cast("cuComplex*") float2 cs);                                     
public static native void cublasZrotg(@Cast("cuDoubleComplex*") double2 ca, @ByVal @Cast("cuDoubleComplex*") double2 cb, DoublePointer sc,
                               @Cast("cuDoubleComplex*") double2 cs);
public static native void cublasZrotg(@Cast("cuDoubleComplex*") double2 ca, @ByVal @Cast("cuDoubleComplex*") double2 cb, DoubleBuffer sc,
                               @Cast("cuDoubleComplex*") double2 cs);
public static native void cublasZrotg(@Cast("cuDoubleComplex*") double2 ca, @ByVal @Cast("cuDoubleComplex*") double2 cb, double[] sc,
                               @Cast("cuDoubleComplex*") double2 cs);                                                               
/*------------------------------------------------------------------------*/
/* ROTM */
public static native void cublasSrotm(int n, FloatPointer x, int incx, FloatPointer y, int incy, 
                              @Const FloatPointer sparam);
public static native void cublasSrotm(int n, FloatBuffer x, int incx, FloatBuffer y, int incy, 
                              @Const FloatBuffer sparam);
public static native void cublasSrotm(int n, float[] x, int incx, float[] y, int incy, 
                              @Const float[] sparam);
public static native void cublasDrotm(int n, DoublePointer x, int incx, DoublePointer y, int incy, 
                              @Const DoublePointer sparam);
public static native void cublasDrotm(int n, DoubleBuffer x, int incx, DoubleBuffer y, int incy, 
                              @Const DoubleBuffer sparam);
public static native void cublasDrotm(int n, double[] x, int incx, double[] y, int incy, 
                              @Const double[] sparam);
/*------------------------------------------------------------------------*/
/* ROTMG */
public static native void cublasSrotmg(FloatPointer sd1, FloatPointer sd2, FloatPointer sx1, 
                                @Const FloatPointer sy1, FloatPointer sparam);
public static native void cublasSrotmg(FloatBuffer sd1, FloatBuffer sd2, FloatBuffer sx1, 
                                @Const FloatBuffer sy1, FloatBuffer sparam);
public static native void cublasSrotmg(float[] sd1, float[] sd2, float[] sx1, 
                                @Const float[] sy1, float[] sparam);
public static native void cublasDrotmg(DoublePointer sd1, DoublePointer sd2, DoublePointer sx1, 
                                @Const DoublePointer sy1, DoublePointer sparam);
public static native void cublasDrotmg(DoubleBuffer sd1, DoubleBuffer sd2, DoubleBuffer sx1, 
                                @Const DoubleBuffer sy1, DoubleBuffer sparam);
public static native void cublasDrotmg(double[] sd1, double[] sd2, double[] sx1, 
                                @Const double[] sy1, double[] sparam);
                           
/* --------------- CUBLAS BLAS2 functions  ---------------- */
/* GEMV */
public static native void cublasSgemv(@Cast("char") byte trans, int m, int n, float alpha,
                               @Const FloatPointer A, int lda, @Const FloatPointer x, int incx,
                               float beta, FloatPointer y, int incy);
public static native void cublasSgemv(@Cast("char") byte trans, int m, int n, float alpha,
                               @Const FloatBuffer A, int lda, @Const FloatBuffer x, int incx,
                               float beta, FloatBuffer y, int incy);
public static native void cublasSgemv(@Cast("char") byte trans, int m, int n, float alpha,
                               @Const float[] A, int lda, @Const float[] x, int incx,
                               float beta, float[] y, int incy);
public static native void cublasDgemv(@Cast("char") byte trans, int m, int n, double alpha,
                               @Const DoublePointer A, int lda, @Const DoublePointer x, int incx,
                               double beta, DoublePointer y, int incy);
public static native void cublasDgemv(@Cast("char") byte trans, int m, int n, double alpha,
                               @Const DoubleBuffer A, int lda, @Const DoubleBuffer x, int incx,
                               double beta, DoubleBuffer y, int incy);
public static native void cublasDgemv(@Cast("char") byte trans, int m, int n, double alpha,
                               @Const double[] A, int lda, @Const double[] x, int incx,
                               double beta, double[] y, int incy);
public static native void cublasCgemv(@Cast("char") byte trans, int m, int n, @ByVal @Cast("cuComplex*") float2 alpha,
                               @Cast("const cuComplex*") float2 A, int lda, @Cast("const cuComplex*") float2 x, int incx,
                               @ByVal @Cast("cuComplex*") float2 beta, @Cast("cuComplex*") float2 y, int incy);
public static native void cublasZgemv(@Cast("char") byte trans, int m, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                               @Cast("const cuDoubleComplex*") double2 A, int lda, @Cast("const cuDoubleComplex*") double2 x, int incx,
                               @ByVal @Cast("cuDoubleComplex*") double2 beta, @Cast("cuDoubleComplex*") double2 y, int incy);
/*------------------------------------------------------------------------*/
/* GBMV */
public static native void cublasSgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               float alpha, @Const FloatPointer A, int lda, 
                               @Const FloatPointer x, int incx, float beta, FloatPointer y, 
                               int incy);
public static native void cublasSgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               float alpha, @Const FloatBuffer A, int lda, 
                               @Const FloatBuffer x, int incx, float beta, FloatBuffer y, 
                               int incy);
public static native void cublasSgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               float alpha, @Const float[] A, int lda, 
                               @Const float[] x, int incx, float beta, float[] y, 
                               int incy);
public static native void cublasDgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               double alpha, @Const DoublePointer A, int lda, 
                               @Const DoublePointer x, int incx, double beta, DoublePointer y, 
                               int incy);
public static native void cublasDgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               double alpha, @Const DoubleBuffer A, int lda, 
                               @Const DoubleBuffer x, int incx, double beta, DoubleBuffer y, 
                               int incy);
public static native void cublasDgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               double alpha, @Const double[] A, int lda, 
                               @Const double[] x, int incx, double beta, double[] y, 
                               int incy);
public static native void cublasCgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A, int lda, 
                               @Cast("const cuComplex*") float2 x, int incx, @ByVal @Cast("cuComplex*") float2 beta, @Cast("cuComplex*") float2 y, 
                               int incy);
public static native void cublasZgbmv(@Cast("char") byte trans, int m, int n, int kl, int ku, 
                               @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 A, int lda, 
                               @Cast("const cuDoubleComplex*") double2 x, int incx, @ByVal @Cast("cuDoubleComplex*") double2 beta, @Cast("cuDoubleComplex*") double2 y, 
                               int incy);                  
/*------------------------------------------------------------------------*/
/* TRMV */
public static native void cublasStrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Const FloatPointer A, int lda, FloatPointer x, int incx);
public static native void cublasStrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Const FloatBuffer A, int lda, FloatBuffer x, int incx);
public static native void cublasStrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Const float[] A, int lda, float[] x, int incx);
public static native void cublasDtrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Const DoublePointer A, int lda, DoublePointer x, int incx);
public static native void cublasDtrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Const DoubleBuffer A, int lda, DoubleBuffer x, int incx);
public static native void cublasDtrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Const double[] A, int lda, double[] x, int incx);
public static native void cublasCtrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Cast("const cuComplex*") float2 A, int lda, @Cast("cuComplex*") float2 x, int incx);
public static native void cublasZtrmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, 
                               @Cast("const cuDoubleComplex*") double2 A, int lda, @Cast("cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* TBMV */
public static native void cublasStbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Const FloatPointer A, int lda, FloatPointer x, int incx);
public static native void cublasStbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Const FloatBuffer A, int lda, FloatBuffer x, int incx);
public static native void cublasStbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Const float[] A, int lda, float[] x, int incx);
public static native void cublasDtbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Const DoublePointer A, int lda, DoublePointer x, int incx);
public static native void cublasDtbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Const DoubleBuffer A, int lda, DoubleBuffer x, int incx);
public static native void cublasDtbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Const double[] A, int lda, double[] x, int incx);
public static native void cublasCtbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Cast("const cuComplex*") float2 A, int lda, @Cast("cuComplex*") float2 x, int incx);
public static native void cublasZtbmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, int k, 
                               @Cast("const cuDoubleComplex*") double2 A, int lda, @Cast("cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* TPMV */                                                    
public static native void cublasStpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const FloatPointer AP, FloatPointer x, int incx);
public static native void cublasStpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const FloatBuffer AP, FloatBuffer x, int incx);
public static native void cublasStpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const float[] AP, float[] x, int incx);

public static native void cublasDtpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const DoublePointer AP, DoublePointer x, int incx);
public static native void cublasDtpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const DoubleBuffer AP, DoubleBuffer x, int incx);
public static native void cublasDtpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const double[] AP, double[] x, int incx);

public static native void cublasCtpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Cast("const cuComplex*") float2 AP, @Cast("cuComplex*") float2 x, int incx);
                                         
public static native void cublasZtpmv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Cast("const cuDoubleComplex*") double2 AP, @Cast("cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/
/* TRSV */
public static native void cublasStrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const FloatPointer A, int lda, FloatPointer x, int incx);
public static native void cublasStrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const FloatBuffer A, int lda, FloatBuffer x, int incx);
public static native void cublasStrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const float[] A, int lda, float[] x, int incx);

public static native void cublasDtrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const DoublePointer A, int lda, DoublePointer x, int incx);
public static native void cublasDtrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const DoubleBuffer A, int lda, DoubleBuffer x, int incx);
public static native void cublasDtrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const double[] A, int lda, double[] x, int incx);

public static native void cublasCtrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Cast("const cuComplex*") float2 A, int lda, @Cast("cuComplex*") float2 x, int incx);

public static native void cublasZtrsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Cast("const cuDoubleComplex*") double2 A, int lda, 
                              @Cast("cuDoubleComplex*") double2 x, int incx);       
/*------------------------------------------------------------------------*/
/* TPSV */
public static native void cublasStpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const FloatPointer AP, 
                              FloatPointer x, int incx);
public static native void cublasStpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const FloatBuffer AP, 
                              FloatBuffer x, int incx);
public static native void cublasStpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const float[] AP, 
                              float[] x, int incx);
                                                                                                            
public static native void cublasDtpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const DoublePointer AP, DoublePointer x, int incx);
public static native void cublasDtpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const DoubleBuffer AP, DoubleBuffer x, int incx);
public static native void cublasDtpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Const double[] AP, double[] x, int incx);

public static native void cublasCtpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Cast("const cuComplex*") float2 AP, @Cast("cuComplex*") float2 x, int incx);

public static native void cublasZtpsv(@Cast("char") byte uplo, @Cast("char") byte trans, @Cast("char") byte diag, int n, @Cast("const cuDoubleComplex*") double2 AP, 
                              @Cast("cuDoubleComplex*") double2 x, int incx);
/*------------------------------------------------------------------------*/                                         
/* TBSV */                                         
public static native void cublasStbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Const FloatPointer A, 
                              int lda, FloatPointer x, int incx);
public static native void cublasStbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Const FloatBuffer A, 
                              int lda, FloatBuffer x, int incx);
public static native void cublasStbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Const float[] A, 
                              int lda, float[] x, int incx);
    
public static native void cublasDtbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Const DoublePointer A, 
                              int lda, DoublePointer x, int incx);
public static native void cublasDtbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Const DoubleBuffer A, 
                              int lda, DoubleBuffer x, int incx);
public static native void cublasDtbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Const double[] A, 
                              int lda, double[] x, int incx);
public static native void cublasCtbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Cast("const cuComplex*") float2 A, 
                              int lda, @Cast("cuComplex*") float2 x, int incx);      
                                         
public static native void cublasZtbsv(@Cast("char") byte uplo, @Cast("char") byte trans, 
                              @Cast("char") byte diag, int n, int k, @Cast("const cuDoubleComplex*") double2 A, 
                              int lda, @Cast("cuDoubleComplex*") double2 x, int incx);  
/*------------------------------------------------------------------------*/                                         
/* SYMV/HEMV */
public static native void cublasSsymv(@Cast("char") byte uplo, int n, float alpha, @Const FloatPointer A,
                               int lda, @Const FloatPointer x, int incx, float beta, 
                               FloatPointer y, int incy);
public static native void cublasSsymv(@Cast("char") byte uplo, int n, float alpha, @Const FloatBuffer A,
                               int lda, @Const FloatBuffer x, int incx, float beta, 
                               FloatBuffer y, int incy);
public static native void cublasSsymv(@Cast("char") byte uplo, int n, float alpha, @Const float[] A,
                               int lda, @Const float[] x, int incx, float beta, 
                               float[] y, int incy);
public static native void cublasDsymv(@Cast("char") byte uplo, int n, double alpha, @Const DoublePointer A,
                               int lda, @Const DoublePointer x, int incx, double beta, 
                               DoublePointer y, int incy);
public static native void cublasDsymv(@Cast("char") byte uplo, int n, double alpha, @Const DoubleBuffer A,
                               int lda, @Const DoubleBuffer x, int incx, double beta, 
                               DoubleBuffer y, int incy);
public static native void cublasDsymv(@Cast("char") byte uplo, int n, double alpha, @Const double[] A,
                               int lda, @Const double[] x, int incx, double beta, 
                               double[] y, int incy);
public static native void cublasChemv(@Cast("char") byte uplo, int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A,
                               int lda, @Cast("const cuComplex*") float2 x, int incx, @ByVal @Cast("cuComplex*") float2 beta, 
                               @Cast("cuComplex*") float2 y, int incy);
public static native void cublasZhemv(@Cast("char") byte uplo, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 A,
                               int lda, @Cast("const cuDoubleComplex*") double2 x, int incx, @ByVal @Cast("cuDoubleComplex*") double2 beta, 
                               @Cast("cuDoubleComplex*") double2 y, int incy);
/*------------------------------------------------------------------------*/       
/* SBMV/HBMV */
public static native void cublasSsbmv(@Cast("char") byte uplo, int n, int k, float alpha, 
                               @Const FloatPointer A, int lda, @Const FloatPointer x, int incx, 
                               float beta, FloatPointer y, int incy);
public static native void cublasSsbmv(@Cast("char") byte uplo, int n, int k, float alpha, 
                               @Const FloatBuffer A, int lda, @Const FloatBuffer x, int incx, 
                               float beta, FloatBuffer y, int incy);
public static native void cublasSsbmv(@Cast("char") byte uplo, int n, int k, float alpha, 
                               @Const float[] A, int lda, @Const float[] x, int incx, 
                               float beta, float[] y, int incy);
public static native void cublasDsbmv(@Cast("char") byte uplo, int n, int k, double alpha, 
                               @Const DoublePointer A, int lda, @Const DoublePointer x, int incx, 
                               double beta, DoublePointer y, int incy);
public static native void cublasDsbmv(@Cast("char") byte uplo, int n, int k, double alpha, 
                               @Const DoubleBuffer A, int lda, @Const DoubleBuffer x, int incx, 
                               double beta, DoubleBuffer y, int incy);
public static native void cublasDsbmv(@Cast("char") byte uplo, int n, int k, double alpha, 
                               @Const double[] A, int lda, @Const double[] x, int incx, 
                               double beta, double[] y, int incy);
public static native void cublasChbmv(@Cast("char") byte uplo, int n, int k, @ByVal @Cast("cuComplex*") float2 alpha, 
                               @Cast("const cuComplex*") float2 A, int lda, @Cast("const cuComplex*") float2 x, int incx, 
                               @ByVal @Cast("cuComplex*") float2 beta, @Cast("cuComplex*") float2 y, int incy);
public static native void cublasZhbmv(@Cast("char") byte uplo, int n, int k, @ByVal @Cast("cuDoubleComplex*") double2 alpha, 
                               @Cast("const cuDoubleComplex*") double2 A, int lda, @Cast("const cuDoubleComplex*") double2 x, int incx, 
                               @ByVal @Cast("cuDoubleComplex*") double2 beta, @Cast("cuDoubleComplex*") double2 y, int incy);
/*------------------------------------------------------------------------*/       
/* SPMV/HPMV */
public static native void cublasSspmv(@Cast("char") byte uplo, int n, float alpha,
                              @Const FloatPointer AP, @Const FloatPointer x,
                              int incx, float beta, FloatPointer y, int incy);
public static native void cublasSspmv(@Cast("char") byte uplo, int n, float alpha,
                              @Const FloatBuffer AP, @Const FloatBuffer x,
                              int incx, float beta, FloatBuffer y, int incy);
public static native void cublasSspmv(@Cast("char") byte uplo, int n, float alpha,
                              @Const float[] AP, @Const float[] x,
                              int incx, float beta, float[] y, int incy);
public static native void cublasDspmv(@Cast("char") byte uplo, int n, double alpha,
                              @Const DoublePointer AP, @Const DoublePointer x,
                              int incx, double beta, DoublePointer y, int incy);
public static native void cublasDspmv(@Cast("char") byte uplo, int n, double alpha,
                              @Const DoubleBuffer AP, @Const DoubleBuffer x,
                              int incx, double beta, DoubleBuffer y, int incy);
public static native void cublasDspmv(@Cast("char") byte uplo, int n, double alpha,
                              @Const double[] AP, @Const double[] x,
                              int incx, double beta, double[] y, int incy);
public static native void cublasChpmv(@Cast("char") byte uplo, int n, @ByVal @Cast("cuComplex*") float2 alpha,
                              @Cast("const cuComplex*") float2 AP, @Cast("const cuComplex*") float2 x,
                              int incx, @ByVal @Cast("cuComplex*") float2 beta, @Cast("cuComplex*") float2 y, int incy);
public static native void cublasZhpmv(@Cast("char") byte uplo, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                              @Cast("const cuDoubleComplex*") double2 AP, @Cast("const cuDoubleComplex*") double2 x,
                              int incx, @ByVal @Cast("cuDoubleComplex*") double2 beta, @Cast("cuDoubleComplex*") double2 y, int incy);

/*------------------------------------------------------------------------*/       
/* GER */
public static native void cublasSger(int m, int n, float alpha, @Const FloatPointer x, int incx,
                              @Const FloatPointer y, int incy, FloatPointer A, int lda);
public static native void cublasSger(int m, int n, float alpha, @Const FloatBuffer x, int incx,
                              @Const FloatBuffer y, int incy, FloatBuffer A, int lda);
public static native void cublasSger(int m, int n, float alpha, @Const float[] x, int incx,
                              @Const float[] y, int incy, float[] A, int lda);
public static native void cublasDger(int m, int n, double alpha, @Const DoublePointer x, int incx,
                              @Const DoublePointer y, int incy, DoublePointer A, int lda);
public static native void cublasDger(int m, int n, double alpha, @Const DoubleBuffer x, int incx,
                              @Const DoubleBuffer y, int incy, DoubleBuffer A, int lda);
public static native void cublasDger(int m, int n, double alpha, @Const double[] x, int incx,
                              @Const double[] y, int incy, double[] A, int lda);

public static native void cublasCgeru(int m, int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 x,
                               int incx, @Cast("const cuComplex*") float2 y, int incy,
                               @Cast("cuComplex*") float2 A, int lda);
public static native void cublasCgerc(int m, int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 x,
                               int incx, @Cast("const cuComplex*") float2 y, int incy,
                               @Cast("cuComplex*") float2 A, int lda);
public static native void cublasZgeru(int m, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 x,
                               int incx, @Cast("const cuDoubleComplex*") double2 y, int incy,
                               @Cast("cuDoubleComplex*") double2 A, int lda);
public static native void cublasZgerc(int m, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 x,
                               int incx, @Cast("const cuDoubleComplex*") double2 y, int incy,
                               @Cast("cuDoubleComplex*") double2 A, int lda);
/*------------------------------------------------------------------------*/       
/* SYR/HER */
public static native void cublasSsyr(@Cast("char") byte uplo, int n, float alpha, @Const FloatPointer x,
                              int incx, FloatPointer A, int lda);
public static native void cublasSsyr(@Cast("char") byte uplo, int n, float alpha, @Const FloatBuffer x,
                              int incx, FloatBuffer A, int lda);
public static native void cublasSsyr(@Cast("char") byte uplo, int n, float alpha, @Const float[] x,
                              int incx, float[] A, int lda);
public static native void cublasDsyr(@Cast("char") byte uplo, int n, double alpha, @Const DoublePointer x,
                              int incx, DoublePointer A, int lda);
public static native void cublasDsyr(@Cast("char") byte uplo, int n, double alpha, @Const DoubleBuffer x,
                              int incx, DoubleBuffer A, int lda);
public static native void cublasDsyr(@Cast("char") byte uplo, int n, double alpha, @Const double[] x,
                              int incx, double[] A, int lda);

public static native void cublasCher(@Cast("char") byte uplo, int n, float alpha, 
                              @Cast("const cuComplex*") float2 x, int incx, @Cast("cuComplex*") float2 A, int lda);
public static native void cublasZher(@Cast("char") byte uplo, int n, double alpha, 
                              @Cast("const cuDoubleComplex*") double2 x, int incx, @Cast("cuDoubleComplex*") double2 A, int lda);

/*------------------------------------------------------------------------*/       
/* SPR/HPR */
public static native void cublasSspr(@Cast("char") byte uplo, int n, float alpha, @Const FloatPointer x,
                              int incx, FloatPointer AP);
public static native void cublasSspr(@Cast("char") byte uplo, int n, float alpha, @Const FloatBuffer x,
                              int incx, FloatBuffer AP);
public static native void cublasSspr(@Cast("char") byte uplo, int n, float alpha, @Const float[] x,
                              int incx, float[] AP);
public static native void cublasDspr(@Cast("char") byte uplo, int n, double alpha, @Const DoublePointer x,
                              int incx, DoublePointer AP);
public static native void cublasDspr(@Cast("char") byte uplo, int n, double alpha, @Const DoubleBuffer x,
                              int incx, DoubleBuffer AP);
public static native void cublasDspr(@Cast("char") byte uplo, int n, double alpha, @Const double[] x,
                              int incx, double[] AP);
public static native void cublasChpr(@Cast("char") byte uplo, int n, float alpha, @Cast("const cuComplex*") float2 x,
                              int incx, @Cast("cuComplex*") float2 AP);
public static native void cublasZhpr(@Cast("char") byte uplo, int n, double alpha, @Cast("const cuDoubleComplex*") double2 x,
                              int incx, @Cast("cuDoubleComplex*") double2 AP);
/*------------------------------------------------------------------------*/       
/* SYR2/HER2 */
public static native void cublasSsyr2(@Cast("char") byte uplo, int n, float alpha, @Const FloatPointer x, 
                               int incx, @Const FloatPointer y, int incy, FloatPointer A, 
                               int lda);
public static native void cublasSsyr2(@Cast("char") byte uplo, int n, float alpha, @Const FloatBuffer x, 
                               int incx, @Const FloatBuffer y, int incy, FloatBuffer A, 
                               int lda);
public static native void cublasSsyr2(@Cast("char") byte uplo, int n, float alpha, @Const float[] x, 
                               int incx, @Const float[] y, int incy, float[] A, 
                               int lda);
public static native void cublasDsyr2(@Cast("char") byte uplo, int n, double alpha, @Const DoublePointer x, 
                               int incx, @Const DoublePointer y, int incy, DoublePointer A, 
                               int lda);
public static native void cublasDsyr2(@Cast("char") byte uplo, int n, double alpha, @Const DoubleBuffer x, 
                               int incx, @Const DoubleBuffer y, int incy, DoubleBuffer A, 
                               int lda);
public static native void cublasDsyr2(@Cast("char") byte uplo, int n, double alpha, @Const double[] x, 
                               int incx, @Const double[] y, int incy, double[] A, 
                               int lda);
public static native void cublasCher2(@Cast("char") byte uplo, int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 x, 
                               int incx, @Cast("const cuComplex*") float2 y, int incy, @Cast("cuComplex*") float2 A, 
                               int lda);
public static native void cublasZher2(@Cast("char") byte uplo, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 x, 
                               int incx, @Cast("const cuDoubleComplex*") double2 y, int incy, @Cast("cuDoubleComplex*") double2 A, 
                               int lda);

/*------------------------------------------------------------------------*/       
/* SPR2/HPR2 */
public static native void cublasSspr2(@Cast("char") byte uplo, int n, float alpha, @Const FloatPointer x, 
                               int incx, @Const FloatPointer y, int incy, FloatPointer AP);
public static native void cublasSspr2(@Cast("char") byte uplo, int n, float alpha, @Const FloatBuffer x, 
                               int incx, @Const FloatBuffer y, int incy, FloatBuffer AP);
public static native void cublasSspr2(@Cast("char") byte uplo, int n, float alpha, @Const float[] x, 
                               int incx, @Const float[] y, int incy, float[] AP);
public static native void cublasDspr2(@Cast("char") byte uplo, int n, double alpha,
                               @Const DoublePointer x, int incx, @Const DoublePointer y,
                               int incy, DoublePointer AP);
public static native void cublasDspr2(@Cast("char") byte uplo, int n, double alpha,
                               @Const DoubleBuffer x, int incx, @Const DoubleBuffer y,
                               int incy, DoubleBuffer AP);
public static native void cublasDspr2(@Cast("char") byte uplo, int n, double alpha,
                               @Const double[] x, int incx, @Const double[] y,
                               int incy, double[] AP);
public static native void cublasChpr2(@Cast("char") byte uplo, int n, @ByVal @Cast("cuComplex*") float2 alpha,
                               @Cast("const cuComplex*") float2 x, int incx, @Cast("const cuComplex*") float2 y,
                               int incy, @Cast("cuComplex*") float2 AP);
public static native void cublasZhpr2(@Cast("char") byte uplo, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                               @Cast("const cuDoubleComplex*") double2 x, int incx, @Cast("const cuDoubleComplex*") double2 y,
                               int incy, @Cast("cuDoubleComplex*") double2 AP);
/* ------------------------BLAS3 Functions ------------------------------- */
/* GEMM */
public static native void cublasSgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k, 
                               float alpha, @Const FloatPointer A, int lda, 
                               @Const FloatPointer B, int ldb, float beta, FloatPointer C, 
                               int ldc);
public static native void cublasSgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k, 
                               float alpha, @Const FloatBuffer A, int lda, 
                               @Const FloatBuffer B, int ldb, float beta, FloatBuffer C, 
                               int ldc);
public static native void cublasSgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k, 
                               float alpha, @Const float[] A, int lda, 
                               @Const float[] B, int ldb, float beta, float[] C, 
                               int ldc);
public static native void cublasDgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k,
                               double alpha, @Const DoublePointer A, int lda, 
                               @Const DoublePointer B, int ldb, double beta, DoublePointer C, 
                               int ldc);
public static native void cublasDgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k,
                               double alpha, @Const DoubleBuffer A, int lda, 
                               @Const DoubleBuffer B, int ldb, double beta, DoubleBuffer C, 
                               int ldc);
public static native void cublasDgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k,
                               double alpha, @Const double[] A, int lda, 
                               @Const double[] B, int ldb, double beta, double[] C, 
                               int ldc);              
public static native void cublasCgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n, int k, 
                               @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A, int lda,
                               @Cast("const cuComplex*") float2 B, int ldb, @ByVal @Cast("cuComplex*") float2 beta,
                               @Cast("cuComplex*") float2 C, int ldc);
public static native void cublasZgemm(@Cast("char") byte transa, @Cast("char") byte transb, int m, int n,
                               int k, @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                               @Cast("const cuDoubleComplex*") double2 A, int lda,
                               @Cast("const cuDoubleComplex*") double2 B, int ldb,
                               @ByVal @Cast("cuDoubleComplex*") double2 beta, @Cast("cuDoubleComplex*") double2 C,
                               int ldc);                   
/* -------------------------------------------------------*/
/* SYRK */
public static native void cublasSsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k, float alpha, 
                               @Const FloatPointer A, int lda, float beta, FloatPointer C, 
                               int ldc);
public static native void cublasSsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k, float alpha, 
                               @Const FloatBuffer A, int lda, float beta, FloatBuffer C, 
                               int ldc);
public static native void cublasSsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k, float alpha, 
                               @Const float[] A, int lda, float beta, float[] C, 
                               int ldc);
public static native void cublasDsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               double alpha, @Const DoublePointer A, int lda,
                               double beta, DoublePointer C, int ldc);
public static native void cublasDsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               double alpha, @Const DoubleBuffer A, int lda,
                               double beta, DoubleBuffer C, int ldc);
public static native void cublasDsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               double alpha, @Const double[] A, int lda,
                               double beta, double[] C, int ldc);

public static native void cublasCsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A, int lda,
                               @ByVal @Cast("cuComplex*") float2 beta, @Cast("cuComplex*") float2 C, int ldc);
public static native void cublasZsyrk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                               @Cast("const cuDoubleComplex*") double2 A, int lda,
                               @ByVal @Cast("cuDoubleComplex*") double2 beta,
                               @Cast("cuDoubleComplex*") double2 C, int ldc);
/* ------------------------------------------------------- */
/* HERK */
public static native void cublasCherk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               float alpha, @Cast("const cuComplex*") float2 A, int lda,
                               float beta, @Cast("cuComplex*") float2 C, int ldc);
public static native void cublasZherk(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                               double alpha,
                               @Cast("const cuDoubleComplex*") double2 A, int lda,
                               double beta,
                               @Cast("cuDoubleComplex*") double2 C, int ldc);
/* ------------------------------------------------------- */
/* SYR2K */
public static native void cublasSsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k, float alpha, 
                                @Const FloatPointer A, int lda, @Const FloatPointer B, int ldb, 
                                float beta, FloatPointer C, int ldc);
public static native void cublasSsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k, float alpha, 
                                @Const FloatBuffer A, int lda, @Const FloatBuffer B, int ldb, 
                                float beta, FloatBuffer C, int ldc);
public static native void cublasSsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k, float alpha, 
                                @Const float[] A, int lda, @Const float[] B, int ldb, 
                                float beta, float[] C, int ldc);

public static native void cublasDsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                double alpha, @Const DoublePointer A, int lda,
                                @Const DoublePointer B, int ldb, double beta,
                                DoublePointer C, int ldc);
public static native void cublasDsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                double alpha, @Const DoubleBuffer A, int lda,
                                @Const DoubleBuffer B, int ldb, double beta,
                                DoubleBuffer C, int ldc);
public static native void cublasDsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                double alpha, @Const double[] A, int lda,
                                @Const double[] B, int ldb, double beta,
                                double[] C, int ldc);
public static native void cublasCsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A, int lda,
                                @Cast("const cuComplex*") float2 B, int ldb, @ByVal @Cast("cuComplex*") float2 beta,
                                @Cast("cuComplex*") float2 C, int ldc);

public static native void cublasZsyr2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 A, int lda,
                                @Cast("const cuDoubleComplex*") double2 B, int ldb, @ByVal @Cast("cuDoubleComplex*") double2 beta,
                                @Cast("cuDoubleComplex*") double2 C, int ldc);                             
/* ------------------------------------------------------- */
/* HER2K */
public static native void cublasCher2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A, int lda,
                                @Cast("const cuComplex*") float2 B, int ldb, float beta,
                                @Cast("cuComplex*") float2 C, int ldc);

public static native void cublasZher2k(@Cast("char") byte uplo, @Cast("char") byte trans, int n, int k,
                                @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 A, int lda,
                                @Cast("const cuDoubleComplex*") double2 B, int ldb, double beta,
                                @Cast("cuDoubleComplex*") double2 C, int ldc); 

/*------------------------------------------------------------------------*/       
/* SYMM*/
public static native void cublasSsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, float alpha, 
                               @Const FloatPointer A, int lda, @Const FloatPointer B, int ldb,
                               float beta, FloatPointer C, int ldc);
public static native void cublasSsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, float alpha, 
                               @Const FloatBuffer A, int lda, @Const FloatBuffer B, int ldb,
                               float beta, FloatBuffer C, int ldc);
public static native void cublasSsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, float alpha, 
                               @Const float[] A, int lda, @Const float[] B, int ldb,
                               float beta, float[] C, int ldc);
public static native void cublasDsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, double alpha, 
                               @Const DoublePointer A, int lda, @Const DoublePointer B, int ldb,
                               double beta, DoublePointer C, int ldc);
public static native void cublasDsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, double alpha, 
                               @Const DoubleBuffer A, int lda, @Const DoubleBuffer B, int ldb,
                               double beta, DoubleBuffer C, int ldc);
public static native void cublasDsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, double alpha, 
                               @Const double[] A, int lda, @Const double[] B, int ldb,
                               double beta, double[] C, int ldc);
          
public static native void cublasCsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, @ByVal @Cast("cuComplex*") float2 alpha, 
                               @Cast("const cuComplex*") float2 A, int lda, @Cast("const cuComplex*") float2 B, int ldb,
                               @ByVal @Cast("cuComplex*") float2 beta, @Cast("cuComplex*") float2 C, int ldc);
          
public static native void cublasZsymm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha, 
                               @Cast("const cuDoubleComplex*") double2 A, int lda, @Cast("const cuDoubleComplex*") double2 B, int ldb,
                               @ByVal @Cast("cuDoubleComplex*") double2 beta, @Cast("cuDoubleComplex*") double2 C, int ldc);
/*------------------------------------------------------------------------*/       
/* HEMM*/
public static native void cublasChemm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n,
                               @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A, int lda,
                               @Cast("const cuComplex*") float2 B, int ldb, @ByVal @Cast("cuComplex*") float2 beta,
                               @Cast("cuComplex*") float2 C, int ldc);
public static native void cublasZhemm(@Cast("char") byte side, @Cast("char") byte uplo, int m, int n,
                               @ByVal @Cast("cuDoubleComplex*") double2 alpha, @Cast("const cuDoubleComplex*") double2 A, int lda,
                               @Cast("const cuDoubleComplex*") double2 B, int ldb, @ByVal @Cast("cuDoubleComplex*") double2 beta,
                               @Cast("cuDoubleComplex*") double2 C, int ldc);  

/*------------------------------------------------------------------------*/       
/* TRSM*/
public static native void cublasStrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, float alpha, @Const FloatPointer A, int lda,
                               FloatPointer B, int ldb);
public static native void cublasStrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, float alpha, @Const FloatBuffer A, int lda,
                               FloatBuffer B, int ldb);
public static native void cublasStrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, float alpha, @Const float[] A, int lda,
                               float[] B, int ldb);

public static native void cublasDtrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, double alpha,
                               @Const DoublePointer A, int lda, DoublePointer B,
                               int ldb);
public static native void cublasDtrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, double alpha,
                               @Const DoubleBuffer A, int lda, DoubleBuffer B,
                               int ldb);
public static native void cublasDtrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, double alpha,
                               @Const double[] A, int lda, double[] B,
                               int ldb);

public static native void cublasCtrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A,
                               int lda, @Cast("cuComplex*") float2 B, int ldb);

public static native void cublasZtrsm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                               @Cast("const cuDoubleComplex*") double2 A, int lda,
                               @Cast("cuDoubleComplex*") double2 B, int ldb);                                                        
/*------------------------------------------------------------------------*/       
/* TRMM*/
public static native void cublasStrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, float alpha, @Const FloatPointer A, int lda,
                               FloatPointer B, int ldb);
public static native void cublasStrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, float alpha, @Const FloatBuffer A, int lda,
                               FloatBuffer B, int ldb);
public static native void cublasStrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, float alpha, @Const float[] A, int lda,
                               float[] B, int ldb);
public static native void cublasDtrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, double alpha,
                               @Const DoublePointer A, int lda, DoublePointer B,
                               int ldb);
public static native void cublasDtrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, double alpha,
                               @Const DoubleBuffer A, int lda, DoubleBuffer B,
                               int ldb);
public static native void cublasDtrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, double alpha,
                               @Const double[] A, int lda, double[] B,
                               int ldb);
public static native void cublasCtrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa, @Cast("char") byte diag,
                               int m, int n, @ByVal @Cast("cuComplex*") float2 alpha, @Cast("const cuComplex*") float2 A,
                               int lda, @Cast("cuComplex*") float2 B, int ldb);
public static native void cublasZtrmm(@Cast("char") byte side, @Cast("char") byte uplo, @Cast("char") byte transa,
                               @Cast("char") byte diag, int m, int n, @ByVal @Cast("cuDoubleComplex*") double2 alpha,
                               @Cast("const cuDoubleComplex*") double2 A, int lda, @Cast("cuDoubleComplex*") double2 B,
                               int ldb);

// #if defined(__cplusplus)
// #endif /* __cplusplus */

// #endif /* !defined(CUBLAS_H_) */


// Parsed from <cublasXt.h>

/*
 * Copyright 1993-2014 NVIDIA Corporation.  All rights reserved.
 *
 * NOTICE TO LICENSEE:
 *
 * This source code and/or documentation ("Licensed Deliverables") are
 * subject to NVIDIA intellectual property rights under U.S. and
 * international Copyright laws.
 *
 * These Licensed Deliverables contained herein is PROPRIETARY and
 * CONFIDENTIAL to NVIDIA and is being provided under the terms and
 * conditions of a form of NVIDIA software license agreement by and
 * between NVIDIA and Licensee ("License Agreement") or electronically
 * accepted by Licensee.  Notwithstanding any terms or conditions to
 * the contrary in the License Agreement, reproduction or disclosure
 * of the Licensed Deliverables to any third party without the express
 * written consent of NVIDIA is prohibited.
 *
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, NVIDIA MAKES NO REPRESENTATION ABOUT THE
 * SUITABILITY OF THESE LICENSED DELIVERABLES FOR ANY PURPOSE.  IT IS
 * PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF ANY KIND.
 * NVIDIA DISCLAIMS ALL WARRANTIES WITH REGARD TO THESE LICENSED
 * DELIVERABLES, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NONINFRINGEMENT, AND FITNESS FOR A PARTICULAR PURPOSE.
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, IN NO EVENT SHALL NVIDIA BE LIABLE FOR ANY
 * SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, OR ANY
 * DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE
 * OF THESE LICENSED DELIVERABLES.
 *
 * U.S. Government End Users.  These Licensed Deliverables are a
 * "commercial item" as that term is defined at 48 C.F.R. 2.101 (OCT
 * 1995), consisting of "commercial computer software" and "commercial
 * computer software documentation" as such terms are used in 48
 * C.F.R. 12.212 (SEPT 1995) and is provided to the U.S. Government
 * only as a commercial end item.  Consistent with 48 C.F.R.12.212 and
 * 48 C.F.R. 227.7202-1 through 227.7202-4 (JUNE 1995), all
 * U.S. Government End Users acquire the Licensed Deliverables with
 * only those rights set forth herein.
 *
 * Any use of the Licensed Deliverables in individual and commercial
 * software must include, in the user documentation and internal
 * comments to the code, the above Disclaimer and U.S. Government End
 * Users Notice.
 */
 
 /*   cublasXt : Host API, Out of Core and Multi-GPU BLAS Library

 */
 
// #if !defined(CUBLAS_XT_H_)
// #define CUBLAS_XT_H_

// #include "driver_types.h"
// #include "cuComplex.h"   /* import complex data type */

// #include "cublas_v2.h"

// #if defined(__cplusplus)
// #endif /* __cplusplus */

@Opaque public static class cublasXtContext extends Pointer {
    /** Empty constructor. */
    public cublasXtContext() { }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public cublasXtContext(Pointer p) { super(p); }
}

public static native @Cast("cublasStatus_t") int cublasXtCreate(@ByPtrPtr cublasXtContext handle);
public static native @Cast("cublasStatus_t") int cublasXtDestroy(cublasXtContext handle);
public static native @Cast("cublasStatus_t") int cublasXtGetNumBoards(int nbDevices, IntPointer deviceId, IntPointer nbBoards);
public static native @Cast("cublasStatus_t") int cublasXtGetNumBoards(int nbDevices, IntBuffer deviceId, IntBuffer nbBoards);
public static native @Cast("cublasStatus_t") int cublasXtGetNumBoards(int nbDevices, int[] deviceId, int[] nbBoards);
public static native @Cast("cublasStatus_t") int cublasXtMaxBoards( IntPointer nbGpuBoards );
public static native @Cast("cublasStatus_t") int cublasXtMaxBoards( IntBuffer nbGpuBoards );
public static native @Cast("cublasStatus_t") int cublasXtMaxBoards( int[] nbGpuBoards );
/* This routine selects the Gpus that the user want to use for CUBLAS-XT */
public static native @Cast("cublasStatus_t") int cublasXtDeviceSelect(cublasXtContext handle, int nbDevices, IntPointer deviceId);
public static native @Cast("cublasStatus_t") int cublasXtDeviceSelect(cublasXtContext handle, int nbDevices, IntBuffer deviceId);
public static native @Cast("cublasStatus_t") int cublasXtDeviceSelect(cublasXtContext handle, int nbDevices, int[] deviceId);

/* This routine allows to change the dimension of the tiles ( blockDim x blockDim ) */
public static native @Cast("cublasStatus_t") int cublasXtSetBlockDim(cublasXtContext handle, int blockDim);
public static native @Cast("cublasStatus_t") int cublasXtGetBlockDim(cublasXtContext handle, IntPointer blockDim);
public static native @Cast("cublasStatus_t") int cublasXtGetBlockDim(cublasXtContext handle, IntBuffer blockDim);
public static native @Cast("cublasStatus_t") int cublasXtGetBlockDim(cublasXtContext handle, int[] blockDim);

/** enum cublasXtPinnedMemMode_t */
public static final int 
    CUBLASXT_PINNING_DISABLED   = 0,  
    CUBLASXT_PINNING_ENABLED    = 1;
/* This routine allows to CUBLAS-XT to pin the Host memory if it find out that some of the matrix passed
   are not pinned : Pinning/Unpinning the Host memory is still a costly operation
   It is better if the user controls the memory on its own (by pinning/unpinning oly when necessary)
*/
public static native @Cast("cublasStatus_t") int cublasXtGetPinningMemMode(cublasXtContext handle, @Cast("cublasXtPinnedMemMode_t*") IntPointer mode);
public static native @Cast("cublasStatus_t") int cublasXtGetPinningMemMode(cublasXtContext handle, @Cast("cublasXtPinnedMemMode_t*") IntBuffer mode);
public static native @Cast("cublasStatus_t") int cublasXtGetPinningMemMode(cublasXtContext handle, @Cast("cublasXtPinnedMemMode_t*") int[] mode);
public static native @Cast("cublasStatus_t") int cublasXtSetPinningMemMode(cublasXtContext handle, @Cast("cublasXtPinnedMemMode_t") int mode);         

/* This routines is to provide a CPU Blas routines, used for too small sizes or hybrid computation */
/** enum cublasXtOpType_t */
public static final int
    CUBLASXT_FLOAT= 0,
    CUBLASXT_DOUBLE= 1,  
    CUBLASXT_COMPLEX= 2,
    CUBLASXT_DOUBLECOMPLEX= 3;

/** enum cublasXtBlasOp_t */
public static final int
    CUBLASXT_GEMM= 0,
    CUBLASXT_SYRK= 1,  
    CUBLASXT_HERK= 2,
    CUBLASXT_SYMM= 3,
    CUBLASXT_HEMM= 4,
    CUBLASXT_TRSM= 5,
    CUBLASXT_SYR2K= 6,  
    CUBLASXT_HER2K= 7,        
        
    CUBLASXT_SPMM= 8,
    CUBLASXT_SYRKX= 9,
    CUBLASXT_HERKX= 10,  
    CUBLASXT_TRMM= 11,  
    CUBLASXT_ROUTINE_MAX= 12;


/* Currently only 32-bit integer BLAS routines are supported */
public static native @Cast("cublasStatus_t") int cublasXtSetCpuRoutine(cublasXtContext handle, @Cast("cublasXtBlasOp_t") int blasOp, @Cast("cublasXtOpType_t") int type, Pointer blasFunctor );

/* Specified the percentage of work that should done by the CPU, default is 0 (no work) */
public static native @Cast("cublasStatus_t") int cublasXtSetCpuRatio(cublasXtContext handle, @Cast("cublasXtBlasOp_t") int blasOp, @Cast("cublasXtOpType_t") int type, float ratio );


/* GEMM */
public static native @Cast("cublasStatus_t") int cublasXtSgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Const FloatPointer alpha,
                                            @Const FloatPointer A, 
                                            @Cast("size_t") long lda,
                                            @Const FloatPointer B,
                                            @Cast("size_t") long ldb, 
                                            @Const FloatPointer beta,
                                            FloatPointer C,
                                            @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtSgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Const FloatBuffer alpha,
                                            @Const FloatBuffer A, 
                                            @Cast("size_t") long lda,
                                            @Const FloatBuffer B,
                                            @Cast("size_t") long ldb, 
                                            @Const FloatBuffer beta,
                                            FloatBuffer C,
                                            @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtSgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Const float[] alpha,
                                            @Const float[] A, 
                                            @Cast("size_t") long lda,
                                            @Const float[] B,
                                            @Cast("size_t") long ldb, 
                                            @Const float[] beta,
                                            float[] C,
                                            @Cast("size_t") long ldc);
                                            
public static native @Cast("cublasStatus_t") int cublasXtDgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Const DoublePointer alpha,
                                            @Const DoublePointer A, 
                                            @Cast("size_t") long lda,
                                            @Const DoublePointer B,
                                            @Cast("size_t") long ldb, 
                                            @Const DoublePointer beta,
                                            DoublePointer C,
                                            @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtDgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Const DoubleBuffer alpha,
                                            @Const DoubleBuffer A, 
                                            @Cast("size_t") long lda,
                                            @Const DoubleBuffer B,
                                            @Cast("size_t") long ldb, 
                                            @Const DoubleBuffer beta,
                                            DoubleBuffer C,
                                            @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtDgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Const double[] alpha,
                                            @Const double[] A, 
                                            @Cast("size_t") long lda,
                                            @Const double[] B,
                                            @Cast("size_t") long ldb, 
                                            @Const double[] beta,
                                            double[] C,
                                            @Cast("size_t") long ldc);
                                            
public static native @Cast("cublasStatus_t") int cublasXtCgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Cast("const cuComplex*") float2 alpha,
                                            @Cast("const cuComplex*") float2 A, 
                                            @Cast("size_t") long lda,
                                            @Cast("const cuComplex*") float2 B,
                                            @Cast("size_t") long ldb, 
                                            @Cast("const cuComplex*") float2 beta,
                                            @Cast("cuComplex*") float2 C,
                                            @Cast("size_t") long ldc);
                                            
public static native @Cast("cublasStatus_t") int cublasXtZgemm(cublasXtContext handle, 
                                            @Cast("cublasOperation_t") int transa,
                                            @Cast("cublasOperation_t") int transb, 
                                            @Cast("size_t") long m,
                                            @Cast("size_t") long n,
                                            @Cast("size_t") long k,
                                            @Cast("const cuDoubleComplex*") double2 alpha,
                                            @Cast("const cuDoubleComplex*") double2 A, 
                                            @Cast("size_t") long lda,
                                            @Cast("const cuDoubleComplex*") double2 B,
                                            @Cast("size_t") long ldb, 
                                            @Cast("const cuDoubleComplex*") double2 beta,
                                            @Cast("cuDoubleComplex*") double2 C,
                                            @Cast("size_t") long ldc);                                                                                             
/* ------------------------------------------------------- */                                 
/* SYRK */
public static native @Cast("cublasStatus_t") int cublasXtSsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const FloatPointer alpha,
                                             @Const FloatPointer A,
                                             @Cast("size_t") long lda,
                                             @Const FloatPointer beta,
                                             FloatPointer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtSsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const FloatBuffer alpha,
                                             @Const FloatBuffer A,
                                             @Cast("size_t") long lda,
                                             @Const FloatBuffer beta,
                                             FloatBuffer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtSsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const float[] alpha,
                                             @Const float[] A,
                                             @Cast("size_t") long lda,
                                             @Const float[] beta,
                                             float[] C,
                                             @Cast("size_t") long ldc );
                                             
public static native @Cast("cublasStatus_t") int cublasXtDsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const DoublePointer alpha,
                                             @Const DoublePointer A,
                                             @Cast("size_t") long lda,
                                             @Const DoublePointer beta,
                                             DoublePointer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const DoubleBuffer alpha,
                                             @Const DoubleBuffer A,
                                             @Cast("size_t") long lda,
                                             @Const DoubleBuffer beta,
                                             DoubleBuffer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const double[] alpha,
                                             @Const double[] A,
                                             @Cast("size_t") long lda,
                                             @Const double[] beta,
                                             double[] C,
                                             @Cast("size_t") long ldc );
                                             
public static native @Cast("cublasStatus_t") int cublasXtCsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Cast("const cuComplex*") float2 alpha,
                                             @Cast("const cuComplex*") float2 A,
                                             @Cast("size_t") long lda,
                                             @Cast("const cuComplex*") float2 beta,
                                             @Cast("cuComplex*") float2 C,
                                             @Cast("size_t") long ldc );
                                             
public static native @Cast("cublasStatus_t") int cublasXtZsyrk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Cast("const cuDoubleComplex*") double2 alpha,
                                             @Cast("const cuDoubleComplex*") double2 A,
                                             @Cast("size_t") long lda,
                                             @Cast("const cuDoubleComplex*") double2 beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );
/* -------------------------------------------------------------------- */                                  
/* HERK */                                
public static native @Cast("cublasStatus_t") int cublasXtCherk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const FloatPointer alpha,
                                             @Cast("const cuComplex*") float2 A,
                                             @Cast("size_t") long lda,
                                             @Const FloatPointer beta,
                                             @Cast("cuComplex*") float2 C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtCherk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const FloatBuffer alpha,
                                             @Cast("const cuComplex*") float2 A,
                                             @Cast("size_t") long lda,
                                             @Const FloatBuffer beta,
                                             @Cast("cuComplex*") float2 C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtCherk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const float[] alpha,
                                             @Cast("const cuComplex*") float2 A,
                                             @Cast("size_t") long lda,
                                             @Const float[] beta,
                                             @Cast("cuComplex*") float2 C,
                                             @Cast("size_t") long ldc );
                                             
public static native @Cast("cublasStatus_t") int cublasXtZherk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const DoublePointer alpha,
                                             @Cast("const cuDoubleComplex*") double2 A,
                                             @Cast("size_t") long lda,
                                             @Const DoublePointer beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtZherk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const DoubleBuffer alpha,
                                             @Cast("const cuDoubleComplex*") double2 A,
                                             @Cast("size_t") long lda,
                                             @Const DoubleBuffer beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtZherk( cublasXtContext handle, 
                                             @Cast("cublasFillMode_t") int uplo, 
                                             @Cast("cublasOperation_t") int trans, 
                                             @Cast("size_t") long n,
                                             @Cast("size_t") long k,
                                             @Const double[] alpha,
                                             @Cast("const cuDoubleComplex*") double2 A,
                                             @Cast("size_t") long lda,
                                             @Const double[] beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );                                                           
/* -------------------------------------------------------------------- */                                              
/* SYR2K */                                     
public static native @Cast("cublasStatus_t") int cublasXtSsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const FloatPointer alpha,   
                                              @Const FloatPointer A,
                                              @Cast("size_t") long lda,
                                              @Const FloatPointer B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatPointer beta,   
                                              FloatPointer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtSsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const FloatBuffer alpha,   
                                              @Const FloatBuffer A,
                                              @Cast("size_t") long lda,
                                              @Const FloatBuffer B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatBuffer beta,   
                                              FloatBuffer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtSsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const float[] alpha,   
                                              @Const float[] A,
                                              @Cast("size_t") long lda,
                                              @Const float[] B,
                                              @Cast("size_t") long ldb,
                                              @Const float[] beta,   
                                              float[] C,
                                              @Cast("size_t") long ldc);  
            
public static native @Cast("cublasStatus_t") int cublasXtDsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const DoublePointer alpha,    
                                              @Const DoublePointer A,
                                              @Cast("size_t") long lda,
                                              @Const DoublePointer B,
                                              @Cast("size_t") long ldb,
                                              @Const DoublePointer beta,   
                                              DoublePointer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtDsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const DoubleBuffer alpha,    
                                              @Const DoubleBuffer A,
                                              @Cast("size_t") long lda,
                                              @Const DoubleBuffer B,
                                              @Cast("size_t") long ldb,
                                              @Const DoubleBuffer beta,   
                                              DoubleBuffer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtDsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const double[] alpha,    
                                              @Const double[] A,
                                              @Cast("size_t") long lda,
                                              @Const double[] B,
                                              @Cast("size_t") long ldb,
                                              @Const double[] beta,   
                                              double[] C,
                                              @Cast("size_t") long ldc);
            
public static native @Cast("cublasStatus_t") int cublasXtCsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Cast("const cuComplex*") float2 beta,   
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);
            
public static native @Cast("cublasStatus_t") int cublasXtZsyr2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,
                                              @Cast("const cuDoubleComplex*") double2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Cast("const cuDoubleComplex*") double2 beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);  
/* -------------------------------------------------------------------- */                                                  
/* HERKX : variant extension of HERK */                                       
public static native @Cast("cublasStatus_t") int cublasXtCherkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatPointer beta,     
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtCherkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatBuffer beta,     
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtCherkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Const float[] beta,     
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);  
            
public static native @Cast("cublasStatus_t") int cublasXtZherkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans, 
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,  
                                              @Cast("const cuDoubleComplex*") double2 A, 
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Const DoublePointer beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtZherkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans, 
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,  
                                              @Cast("const cuDoubleComplex*") double2 A, 
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Const DoubleBuffer beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtZherkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans, 
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,  
                                              @Cast("const cuDoubleComplex*") double2 A, 
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Const double[] beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);       
                         
/* -------------------------------------------------------------------- */                                
/* TRSM */                                                                         
public static native @Cast("cublasStatus_t") int cublasXtStrsm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const FloatPointer alpha,
                                             @Const FloatPointer A,
                                             @Cast("size_t") long lda,
                                             FloatPointer B,
                                             @Cast("size_t") long ldb);
public static native @Cast("cublasStatus_t") int cublasXtStrsm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const FloatBuffer alpha,
                                             @Const FloatBuffer A,
                                             @Cast("size_t") long lda,
                                             FloatBuffer B,
                                             @Cast("size_t") long ldb);
public static native @Cast("cublasStatus_t") int cublasXtStrsm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const float[] alpha,
                                             @Const float[] A,
                                             @Cast("size_t") long lda,
                                             float[] B,
                                             @Cast("size_t") long ldb);
    

public static native @Cast("cublasStatus_t") int cublasXtDtrsm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const DoublePointer alpha, 
                                             @Const DoublePointer A, 
                                             @Cast("size_t") long lda, 
                                             DoublePointer B,
                                             @Cast("size_t") long ldb);
public static native @Cast("cublasStatus_t") int cublasXtDtrsm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const DoubleBuffer alpha, 
                                             @Const DoubleBuffer A, 
                                             @Cast("size_t") long lda, 
                                             DoubleBuffer B,
                                             @Cast("size_t") long ldb);
public static native @Cast("cublasStatus_t") int cublasXtDtrsm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const double[] alpha, 
                                             @Const double[] A, 
                                             @Cast("size_t") long lda, 
                                             double[] B,
                                             @Cast("size_t") long ldb);
    
public static native @Cast("cublasStatus_t") int cublasXtCtrsm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuComplex*") float2 alpha, 
                                             @Cast("const cuComplex*") float2 A,
                                             @Cast("size_t") long lda,
                                             @Cast("cuComplex*") float2 B,
                                             @Cast("size_t") long ldb);
                  
public static native @Cast("cublasStatus_t") int cublasXtZtrsm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("cublasOperation_t") int trans,
                                             @Cast("cublasDiagType_t") int diag,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuDoubleComplex*") double2 alpha, 
                                             @Cast("const cuDoubleComplex*") double2 A,                                        
                                             @Cast("size_t") long lda,
                                             @Cast("cuDoubleComplex*") double2 B,
                                             @Cast("size_t") long ldb);       
/* -------------------------------------------------------------------- */                                
/* SYMM : Symmetric Multiply Matrix*/                                                                         
public static native @Cast("cublasStatus_t") int cublasXtSsymm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const FloatPointer alpha,
                                             @Const FloatPointer A,
                                             @Cast("size_t") long lda,
                                             @Const FloatPointer B,
                                             @Cast("size_t") long ldb,
                                             @Const FloatPointer beta,
                                             FloatPointer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtSsymm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const FloatBuffer alpha,
                                             @Const FloatBuffer A,
                                             @Cast("size_t") long lda,
                                             @Const FloatBuffer B,
                                             @Cast("size_t") long ldb,
                                             @Const FloatBuffer beta,
                                             FloatBuffer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtSsymm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const float[] alpha,
                                             @Const float[] A,
                                             @Cast("size_t") long lda,
                                             @Const float[] B,
                                             @Cast("size_t") long ldb,
                                             @Const float[] beta,
                                             float[] C,
                                             @Cast("size_t") long ldc );    

public static native @Cast("cublasStatus_t") int cublasXtDsymm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const DoublePointer alpha, 
                                             @Const DoublePointer A, 
                                             @Cast("size_t") long lda,
                                             @Const DoublePointer B,
                                             @Cast("size_t") long ldb,
                                             @Const DoublePointer beta,
                                             DoublePointer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDsymm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const DoubleBuffer alpha, 
                                             @Const DoubleBuffer A, 
                                             @Cast("size_t") long lda,
                                             @Const DoubleBuffer B,
                                             @Cast("size_t") long ldb,
                                             @Const DoubleBuffer beta,
                                             DoubleBuffer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDsymm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const double[] alpha, 
                                             @Const double[] A, 
                                             @Cast("size_t") long lda,
                                             @Const double[] B,
                                             @Cast("size_t") long ldb,
                                             @Const double[] beta,
                                             double[] C,
                                             @Cast("size_t") long ldc );                                 
    
public static native @Cast("cublasStatus_t") int cublasXtCsymm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuComplex*") float2 alpha, 
                                             @Cast("const cuComplex*") float2 A,
                                             @Cast("size_t") long lda,
                                             @Cast("const cuComplex*") float2 B,
                                             @Cast("size_t") long ldb,
                                             @Cast("const cuComplex*") float2 beta,
                                             @Cast("cuComplex*") float2 C,
                                             @Cast("size_t") long ldc );                                 
                  
public static native @Cast("cublasStatus_t") int cublasXtZsymm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuDoubleComplex*") double2 alpha, 
                                             @Cast("const cuDoubleComplex*") double2 A,  
                                             @Cast("size_t") long lda,                                      
                                             @Cast("const cuDoubleComplex*") double2 B,
                                             @Cast("size_t") long ldb,
                                             @Cast("const cuDoubleComplex*") double2 beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );  
/* -------------------------------------------------------------------- */                                         
/* HEMM : Hermitian Matrix Multiply */                                       
 public static native @Cast("cublasStatus_t") int cublasXtChemm( cublasXtContext handle,
                                              @Cast("cublasSideMode_t") int side,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("size_t") long m,
                                              @Cast("size_t") long n,
                                              @Cast("const cuComplex*") float2 alpha, 
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Cast("const cuComplex*") float2 beta,
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc );                                 
                  
public static native @Cast("cublasStatus_t") int cublasXtZhemm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuDoubleComplex*") double2 alpha, 
                                             @Cast("const cuDoubleComplex*") double2 A,  
                                             @Cast("size_t") long lda,                                      
                                             @Cast("const cuDoubleComplex*") double2 B,
                                             @Cast("size_t") long ldb,
                                             @Cast("const cuDoubleComplex*") double2 beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );  

/* -------------------------------------------------------------------- */ 
/* SYRKX : variant extension of SYRK  */                                     
public static native @Cast("cublasStatus_t") int cublasXtSsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const FloatPointer alpha,   
                                              @Const FloatPointer A,
                                              @Cast("size_t") long lda,
                                              @Const FloatPointer B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatPointer beta,   
                                              FloatPointer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtSsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const FloatBuffer alpha,   
                                              @Const FloatBuffer A,
                                              @Cast("size_t") long lda,
                                              @Const FloatBuffer B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatBuffer beta,   
                                              FloatBuffer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtSsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const float[] alpha,   
                                              @Const float[] A,
                                              @Cast("size_t") long lda,
                                              @Const float[] B,
                                              @Cast("size_t") long ldb,
                                              @Const float[] beta,   
                                              float[] C,
                                              @Cast("size_t") long ldc);  
            
public static native @Cast("cublasStatus_t") int cublasXtDsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const DoublePointer alpha,    
                                              @Const DoublePointer A,
                                              @Cast("size_t") long lda,
                                              @Const DoublePointer B,
                                              @Cast("size_t") long ldb,
                                              @Const DoublePointer beta,   
                                              DoublePointer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtDsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const DoubleBuffer alpha,    
                                              @Const DoubleBuffer A,
                                              @Cast("size_t") long lda,
                                              @Const DoubleBuffer B,
                                              @Cast("size_t") long ldb,
                                              @Const DoubleBuffer beta,   
                                              DoubleBuffer C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtDsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Const double[] alpha,    
                                              @Const double[] A,
                                              @Cast("size_t") long lda,
                                              @Const double[] B,
                                              @Cast("size_t") long ldb,
                                              @Const double[] beta,   
                                              double[] C,
                                              @Cast("size_t") long ldc);
            
public static native @Cast("cublasStatus_t") int cublasXtCsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Cast("const cuComplex*") float2 beta,   
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);
            
public static native @Cast("cublasStatus_t") int cublasXtZsyrkx( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,
                                              @Cast("const cuDoubleComplex*") double2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Cast("const cuDoubleComplex*") double2 beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);  
/* -------------------------------------------------------------------- */                                          
/* HER2K : variant extension of HERK  */                                    
public static native @Cast("cublasStatus_t") int cublasXtCher2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatPointer beta,     
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtCher2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Const FloatBuffer beta,     
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtCher2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans,
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuComplex*") float2 alpha,   
                                              @Cast("const cuComplex*") float2 A,
                                              @Cast("size_t") long lda,
                                              @Cast("const cuComplex*") float2 B,
                                              @Cast("size_t") long ldb,
                                              @Const float[] beta,     
                                              @Cast("cuComplex*") float2 C,
                                              @Cast("size_t") long ldc);  
            
public static native @Cast("cublasStatus_t") int cublasXtZher2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans, 
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,  
                                              @Cast("const cuDoubleComplex*") double2 A, 
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Const DoublePointer beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtZher2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans, 
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,  
                                              @Cast("const cuDoubleComplex*") double2 A, 
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Const DoubleBuffer beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);
public static native @Cast("cublasStatus_t") int cublasXtZher2k( cublasXtContext handle,
                                              @Cast("cublasFillMode_t") int uplo,
                                              @Cast("cublasOperation_t") int trans, 
                                              @Cast("size_t") long n,
                                              @Cast("size_t") long k,
                                              @Cast("const cuDoubleComplex*") double2 alpha,  
                                              @Cast("const cuDoubleComplex*") double2 A, 
                                              @Cast("size_t") long lda,
                                              @Cast("const cuDoubleComplex*") double2 B,
                                              @Cast("size_t") long ldb,
                                              @Const double[] beta,   
                                              @Cast("cuDoubleComplex*") double2 C,
                                              @Cast("size_t") long ldc);       
                         
                                
/* -------------------------------------------------------------------- */                                              
/* SPMM : Symmetric Packed Multiply Matrix*/                                                                         
public static native @Cast("cublasStatus_t") int cublasXtSspmm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const FloatPointer alpha,
                                             @Const FloatPointer AP,
                                             @Const FloatPointer B,
                                             @Cast("size_t") long ldb,
                                             @Const FloatPointer beta,
                                             FloatPointer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtSspmm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const FloatBuffer alpha,
                                             @Const FloatBuffer AP,
                                             @Const FloatBuffer B,
                                             @Cast("size_t") long ldb,
                                             @Const FloatBuffer beta,
                                             FloatBuffer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtSspmm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const float[] alpha,
                                             @Const float[] AP,
                                             @Const float[] B,
                                             @Cast("size_t") long ldb,
                                             @Const float[] beta,
                                             float[] C,
                                             @Cast("size_t") long ldc );    

public static native @Cast("cublasStatus_t") int cublasXtDspmm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const DoublePointer alpha, 
                                             @Const DoublePointer AP, 
                                             @Const DoublePointer B,
                                             @Cast("size_t") long ldb,
                                             @Const DoublePointer beta,
                                             DoublePointer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDspmm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const DoubleBuffer alpha, 
                                             @Const DoubleBuffer AP, 
                                             @Const DoubleBuffer B,
                                             @Cast("size_t") long ldb,
                                             @Const DoubleBuffer beta,
                                             DoubleBuffer C,
                                             @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDspmm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Const double[] alpha, 
                                             @Const double[] AP, 
                                             @Const double[] B,
                                             @Cast("size_t") long ldb,
                                             @Const double[] beta,
                                             double[] C,
                                             @Cast("size_t") long ldc );                                 
    
public static native @Cast("cublasStatus_t") int cublasXtCspmm( cublasXtContext handle,
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuComplex*") float2 alpha, 
                                             @Cast("const cuComplex*") float2 AP,
                                             @Cast("const cuComplex*") float2 B,
                                             @Cast("size_t") long ldb,
                                             @Cast("const cuComplex*") float2 beta,
                                             @Cast("cuComplex*") float2 C,
                                             @Cast("size_t") long ldc );                                 
                  
public static native @Cast("cublasStatus_t") int cublasXtZspmm( cublasXtContext handle, 
                                             @Cast("cublasSideMode_t") int side,
                                             @Cast("cublasFillMode_t") int uplo,
                                             @Cast("size_t") long m,
                                             @Cast("size_t") long n,
                                             @Cast("const cuDoubleComplex*") double2 alpha, 
                                             @Cast("const cuDoubleComplex*") double2 AP,                                        
                                             @Cast("const cuDoubleComplex*") double2 B,
                                             @Cast("size_t") long ldb,
                                             @Cast("const cuDoubleComplex*") double2 beta,
                                             @Cast("cuDoubleComplex*") double2 C,
                                             @Cast("size_t") long ldc );                                                                                                       
                                             
/* -------------------------------------------------------------------- */   
/* TRMM */                                                                                    
public static native @Cast("cublasStatus_t") int cublasXtStrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Const FloatPointer alpha, 
                                           @Const FloatPointer A,
                                           @Cast("size_t") long lda,
                                           @Const FloatPointer B,
                                           @Cast("size_t") long ldb,
                                           FloatPointer C,
                                           @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtStrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Const FloatBuffer alpha, 
                                           @Const FloatBuffer A,
                                           @Cast("size_t") long lda,
                                           @Const FloatBuffer B,
                                           @Cast("size_t") long ldb,
                                           FloatBuffer C,
                                           @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtStrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Const float[] alpha, 
                                           @Const float[] A,
                                           @Cast("size_t") long lda,
                                           @Const float[] B,
                                           @Cast("size_t") long ldb,
                                           float[] C,
                                           @Cast("size_t") long ldc );

public static native @Cast("cublasStatus_t") int cublasXtDtrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Const DoublePointer alpha, 
                                           @Const DoublePointer A,
                                           @Cast("size_t") long lda,
                                           @Const DoublePointer B,
                                           @Cast("size_t") long ldb,
                                           DoublePointer C,
                                           @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDtrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Const DoubleBuffer alpha, 
                                           @Const DoubleBuffer A,
                                           @Cast("size_t") long lda,
                                           @Const DoubleBuffer B,
                                           @Cast("size_t") long ldb,
                                           DoubleBuffer C,
                                           @Cast("size_t") long ldc );
public static native @Cast("cublasStatus_t") int cublasXtDtrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Const double[] alpha, 
                                           @Const double[] A,
                                           @Cast("size_t") long lda,
                                           @Const double[] B,
                                           @Cast("size_t") long ldb,
                                           double[] C,
                                           @Cast("size_t") long ldc );

public static native @Cast("cublasStatus_t") int cublasXtCtrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Cast("const cuComplex*") float2 alpha, 
                                           @Cast("const cuComplex*") float2 A,
                                           @Cast("size_t") long lda,
                                           @Cast("const cuComplex*") float2 B,
                                           @Cast("size_t") long ldb,
                                           @Cast("cuComplex*") float2 C,
                                           @Cast("size_t") long ldc );

public static native @Cast("cublasStatus_t") int cublasXtZtrmm( cublasXtContext handle,
                                           @Cast("cublasSideMode_t") int side,
                                           @Cast("cublasFillMode_t") int uplo, 
                                           @Cast("cublasOperation_t") int trans,
                                           @Cast("cublasDiagType_t") int diag,                               
                                           @Cast("size_t") long m,
                                           @Cast("size_t") long n,
                                           @Cast("const cuDoubleComplex*") double2 alpha, 
                                           @Cast("const cuDoubleComplex*") double2 A,
                                           @Cast("size_t") long lda,
                                           @Cast("const cuDoubleComplex*") double2 B,
                                           @Cast("size_t") long ldb,
                                           @Cast("cuDoubleComplex*") double2 C,
                                           @Cast("size_t") long ldc );
                                             
                                
// #if defined(__cplusplus)
// #endif /* __cplusplus */


// #endif /* !defined(CUBLAS_XT_H_) */


}
